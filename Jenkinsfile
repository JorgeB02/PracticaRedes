pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Clonar el repositorio de GitHub
                git branch: 'main', url: 'https://github.com/username/repo.git'
            }
        }

        stage('Build') {
            steps {
                // Construir la aplicación con Maven
                sh './mvnw clean package'
            }
        }

        stage('Test') {
            steps {
                // Ejecutar pruebas unitarias
                sh './mvnw test'
            }
        }

        stage('Deploy') {
            steps {
                // Desplegar la aplicación en un servidor
                sh './mvnw spring-boot:run'
            }
        }
    }
}
