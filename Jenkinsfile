pipeline {
  agent { docker { image 'openjdk:8' } }
  stages {
    stage('build') {
      steps {
          sh './gradlew --no-daemon'
      }
    }
    stage('lint'){
      steps{
        script {
          try {
            sh './gradlew lint'
          } catch (Exception e) {
            echo e.getMessage()
            echo "Lint failed"
          }
        }       
      }
    }
    stage('debug'){
      steps{
        script {
          try {
            sh './gradlew tasks --all'
          } catch (Exception e) {
            echo e.getMessage()
            echo "Debug failed"
          }
        }       
      }
    }
    stage('release'){
      steps{
        script {
          try {
            sh './gradlew test'
          } catch (Exception e) {
            echo e.getMessage()
            echo "Release failed"
          }
        }       
      }
    }
  }
} 