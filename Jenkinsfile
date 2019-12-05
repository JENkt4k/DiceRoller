pipeline {
  agent { docker { image 'circleci/android:api-29-node' } }
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
            sh './gradlew check'
          } catch (Exception e) {
            echo e.getMessage()
            echo "Lint failed"
          }
        }       
      }
      post {
        always {
            junit 'app/build/reports/**/*.xml'
        }
      }
    }  
  }
} 