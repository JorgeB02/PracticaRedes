pipeline {
    environment {
        registry = "tu_usuario_docker_hub/proyecto"
        registryCredential = 'docker-hub'
        dockerImage = ''
    }
    agent any
    stages {
        stage('Clonar código fuente') {
            steps {
                git 'https://github.com/tu_usuario/proyecto.git'
            }
        }
        stage('Construir aplicación') {
            steps {
                sh './mvnw -B -DskipTests clean package'
            }
        }
        stage('Construir imagen Docker') {
            steps{
                script {
                    dockerImage = docker.build registry + ":${env.BUILD_NUMBER}"
                }
            }
        }
        stage('Etiquetar imagen Docker') {
            steps{
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.tag "${env.BUILD_NUMBER}", "${registry}:latest"
                    }
                }
            }
        }
        stage('Publicar imagen Docker en Docker Hub') {
            steps{
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Limpiar recursos') {
            steps {
                sh 'docker rmi ${registry}:${BUILD_NUMBER}'
            }
        }
    }
}
