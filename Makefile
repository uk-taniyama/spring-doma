.PHONY: help ## このメッセージを表示します。(default)
help:
	@grep " #""# " Makefile | sed -e 's/.PHONY: *//' | sed -e 's/ *## */\t/'

.PHONY: run ## 実行する。
run:
	# rm -rf src/main/java/example/
	# rm -rf src/main/java/org/
	# rm -rf build
	sh gradlew bootRun

.PHONY: lint ## lintする。
lint:
	sh gradlew spotlessApply

.PHONY: gen ## コード生成します。
gen:
	sh gradlew domaCodeGenDevAll spotlessJavaApply --info
	# sh gradlew domaCodeGenDevAll --debug | grep org.seasar.doma.gradle.codegen

.PHONY: gen-sql
gen-sql:
	sh gradlew domaCodeGenDevSql domaCodeGenDevSqlTest spotlessJavaApply --info

.PHONY: test ## テストを実行する。
test:
	sh gradlew test

.PHONY: clean ## きれいにする。
clean:
	rm -rf build

.PHONY: TEST ## テストを再実行する。
TEST:
	sh gradlew --rerun-tasks test
	# sh gradlew --rerun-tasks --debug test

.PHONY: preLaunchTask ## vscodeのテスト用。
preLaunchTask:
	# sh gradlew compileJava copyToBin

.PHONY: get-doma
get-doma:
	git clone --depth 1 --branch v2.0.0 https://github.com/domaframework/doma-codegen-plugin
	cp -r doma-codegen-plugin/codegen/src/main/resources/org/seasar/doma/gradle/codegen/template/* template/
	mv template/java/* template
	rm -rf template/kotlin doma-codegen-plugin

.PHONY: show-report
show-report:
	npx http-server build/reports/tests/test/
