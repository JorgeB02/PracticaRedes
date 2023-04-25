pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh './mvnw clean package'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                sh 'docker build -t myapp .'
            }
        }
        stage('Deploy') {
            environment {
                CONTAINER_NAME = 'myapp-container'
                PORT = '8080'
            }
            steps {
                sh 'docker stop $CONTAINER_NAME || true'
                sh 'docker rm $CONTAINER_NAME || true'
                sh "docker run -d -p $PORT:$PORT --name $CONTAINER_NAME myapp"
            }
        }
    }
}
