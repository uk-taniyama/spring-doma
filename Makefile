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

.PHONY: test ## テストを実行する。
test:
	sh gradlew test

.PHONY: TEST ## テストを再実行する。
TEST:
	sh gradlew --rerun-tasks test
	# sh gradlew --rerun-tasks --debug test

.PHONY: to-bin ## sqlをいじったりして、VSCodeでのビルドとかテストがうまくいかないときに実行する。
to-bin:
	sh gradlew compileJava copyToBin

.PHONY: get-doma
get-doma:
	git clone --depth 1 --branch v2.0.0 https://github.com/domaframework/doma-codegen-plugin
	cp -r doma-codegen-plugin/codegen/src/main/resources/org/seasar/doma/gradle/codegen/template/* template/
