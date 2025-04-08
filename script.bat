@echo off
set JAVA_DIR=src\main\java
set CLASS_DIR=src\main\webapps\WEB-INF\classes
set LIB_SRC=lib
set WEBAPP_DIR=src\main\webapps
set BUILD_DIR=build
set TOMCAT_DIR=C:\apache-tomcat-10.1.28\webapps

rem Compilation de toutes les classes avec une boucle
for /r %JAVA_DIR% %%f in (*.java) do (
    javac -d %CLASS_DIR% -cp "%LIB_SRC%\*;%CLASS_DIR%" "%%f"
)

rem Vérification des fichiers compilés
echo "Compilation terminée, voici les fichiers générés:"
dir /s %CLASS_DIR%

rem Copie des fichiers nécessaires
xcopy %WEBAPP_DIR% %BUILD_DIR% /E /I /Y

rem Création du fichier WAR
jar -cvf ETU003337.war -C %BUILD_DIR% .

rem Déploiement sur Tomcat
move ETU003337.war %TOMCAT_DIR%

pause
