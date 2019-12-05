pipeline {
  agent { docker { image 'openjdk:8' } }
  stages {
    stage('build') {
      steps {
          sh 'pwd'
          sh 'ls'
          sh 'ls'
          sh './gradlew --no-daemon'
      }
    }
  }
} 