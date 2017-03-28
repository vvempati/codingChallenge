@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  application startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Add default JVM options here. You can also use JAVA_OPTS and APPLICATION_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windows variants

if not "%OS%" == "Windows_NT" goto win9xME_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\application.jar;%APP_HOME%\lib\vertx-core-3.3.2.jar;%APP_HOME%\lib\vertx-web-3.3.2.jar;%APP_HOME%\lib\vertx-codegen-3.3.2.jar;%APP_HOME%\lib\vertx-rx-java-3.3.2.jar;%APP_HOME%\lib\vertx-auth-common-3.3.2.jar;%APP_HOME%\lib\kotlin-stdlib-1.0.6.jar;%APP_HOME%\lib\expekt-0.4.0.jar;%APP_HOME%\lib\mockito-kotlin-0.9.0.jar;%APP_HOME%\lib\jlorem-1.1.jar;%APP_HOME%\lib\auth0-0.4.0.jar;%APP_HOME%\lib\jackson-module-kotlin-2.8.4.jar;%APP_HOME%\lib\jtds-1.3.1.jar;%APP_HOME%\lib\cassandra-driver-core-3.1.1.jar;%APP_HOME%\lib\cassandra-driver-mapping-3.1.1.jar;%APP_HOME%\lib\jdbi-2.77.jar;%APP_HOME%\lib\spek-api-1.0.89.jar;%APP_HOME%\lib\spek-junit-platform-engine-1.0.89.jar;%APP_HOME%\lib\netty-common-4.1.1.Final.jar;%APP_HOME%\lib\netty-buffer-4.1.1.Final.jar;%APP_HOME%\lib\netty-transport-4.1.1.Final.jar;%APP_HOME%\lib\netty-handler-4.1.1.Final.jar;%APP_HOME%\lib\netty-handler-proxy-4.1.1.Final.jar;%APP_HOME%\lib\netty-codec-http-4.1.1.Final.jar;%APP_HOME%\lib\netty-codec-http2-4.1.1.Final.jar;%APP_HOME%\lib\netty-resolver-4.1.1.Final.jar;%APP_HOME%\lib\netty-resolver-dns-4.1.1.Final.jar;%APP_HOME%\lib\mvel2-2.2.8.Final.jar;%APP_HOME%\lib\rxjava-1.1.5.jar;%APP_HOME%\lib\kotlin-reflect-1.0.4.jar;%APP_HOME%\lib\mockito-core-2.2.6.jar;%APP_HOME%\lib\gson-2.6.2.jar;%APP_HOME%\lib\okhttp-2.5.0.jar;%APP_HOME%\lib\jackson-annotations-2.8.0.jar;%APP_HOME%\lib\guava-16.0.1.jar;%APP_HOME%\lib\metrics-core-3.1.2.jar;%APP_HOME%\lib\jnr-ffi-2.0.7.jar;%APP_HOME%\lib\jnr-posix-3.0.27.jar;%APP_HOME%\lib\netty-codec-socks-4.1.1.Final.jar;%APP_HOME%\lib\netty-codec-4.1.1.Final.jar;%APP_HOME%\lib\netty-codec-dns-4.1.1.Final.jar;%APP_HOME%\lib\byte-buddy-1.4.33.jar;%APP_HOME%\lib\byte-buddy-agent-1.4.33.jar;%APP_HOME%\lib\objenesis-2.4.jar;%APP_HOME%\lib\okio-1.6.0.jar;%APP_HOME%\lib\slf4j-api-1.7.7.jar;%APP_HOME%\lib\jffi-1.2.10.jar;%APP_HOME%\lib\jffi-1.2.10-native.jar;%APP_HOME%\lib\asm-5.0.3.jar;%APP_HOME%\lib\asm-commons-5.0.3.jar;%APP_HOME%\lib\asm-analysis-5.0.3.jar;%APP_HOME%\lib\asm-tree-5.0.3.jar;%APP_HOME%\lib\asm-util-5.0.3.jar;%APP_HOME%\lib\jnr-x86asm-1.0.2.jar;%APP_HOME%\lib\jnr-constants-0.9.0.jar;%APP_HOME%\lib\kotlin-runtime-1.0.6.jar;%APP_HOME%\lib\jackson-databind-2.8.4.jar;%APP_HOME%\lib\jackson-core-2.8.4.jar

@rem Execute application
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %APPLICATION_OPTS%  -classpath "%CLASSPATH%" io.vertx.core.Launcher %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable APPLICATION_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%APPLICATION_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
