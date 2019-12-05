pipeline {
  agent { docker { image 'openjdk:8' } }
  stages {
    stage('build') {
      steps {
          sh './gradlew --no-daemon'
      }
    }
  }
} 