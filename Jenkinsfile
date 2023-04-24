pipeline {
    agent any
    stages {
        stage('Compile code') {
            steps {
                sh 'mvn compile'
            }
        }
        stage('Build Docker image') {
            steps {
                sh 'docker build -t nombre-imagen .'
            }
        }
        stage('Run tests') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Deploy to Docker') {
            steps {
                sh 'docker run -p 8090 nombre-imagen'
            }
        }
    }
}
