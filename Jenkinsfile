pipeline {
  agent any
  
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean package'
      }
    }
    
    stage('Build Docker image') {
      steps {
        script {
          docker.build("mi-app:latest")
        }
      }
    }
    
    stage('Push Docker image to registry') {
      steps {
        script {
          docker.withRegistry('https://registry.example.com', 'docker-registry-credentials') {
            dockerImage.push()
          }
        }
      }
    }
    
    stage('Deploy') {
      when {
        branch 'master'
      }
      steps {
        sh 'docker-compose up -d'
      }
    }
  }
}

}
