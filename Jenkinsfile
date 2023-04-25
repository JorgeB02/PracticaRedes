pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM',
                    branches: [[name: '*/master']],
                    userRemoteConfigs: [[credentialsId: 'git-credentials', url: 'https://github.com/username/repo.git']]])
            }
        }
        stage('Build') {
            steps {
                sh './mvnw clean package'
            }
        }
        stage('Build Docker image') {
            steps {
                sh 'docker build -t my-app .'
            }
        }
        stage('Run Docker container') {
            steps {
                sh 'docker run -d -p 8080:8080 my-app'
            }
        }
        stage('Deploy') {
            steps {
                sh 'curl -X POST http://jenkins-server:8080/job/my-app/build?delay=0sec'
            }
        }
    }
    post {
        success {
            echo 'CI/CD pipeline completed successfully'
        }
        failure {
            echo 'CI/CD pipeline failed'
        }
    }
}
