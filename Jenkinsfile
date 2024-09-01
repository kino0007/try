pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        gradle "gradle"
    }

    stages {
        stage('Build') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/kino0007/try.git']])
                script {
                    if (isUnix()) {
                        sh './gradlew clean build'
                    } else {
                        bat 'gradlew.bat clean build'
                    }
                }
            }
        }
        stage('Stop Container if Running') {
            steps {
                script {
                    bat '''
                            @echo off & for /F "tokens=*" %%i in ('docker ps -q --filter "name=backend"') do docker stop %%i & docker rm %%i
                            exit
                        '''
                }
            }
        }
        stage('Remove Docker Image If Exist') {
            steps {
                script{
                    bat '''
                    @echo off
                    for /F "tokens=*" %%i in ('docker ps -a -q --filter ancestor=spring-backend:dev') do (
                    docker stop %%i
                    docker rm %%i
                    )
                    docker rmi -f spring-backend:dev
                    exit
                    '''
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    bat 'docker build -t spring-backend:dev .'
                }
            }
        }
        stage('Run Docker Image') {
            steps {
                script {
                    bat 'docker run -d --name backend -p 8080:8080 spring-backend:dev'
                }
            }
        }
        stage('Complete Job') {
            steps {
                script {
                    echo 'Job completed successfully!'
                }
            }
        }
    }
}