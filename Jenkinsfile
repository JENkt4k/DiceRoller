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
            sh './gradlew testDebugUnitTest'
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
            sh './gradlew testReleaseUnitTest'
          } catch (Exception e) {
            echo e.getMessage()
            echo "Release failed"
          }
        }       
      }
    }
    post {
        always {
            dir('/app/build/reports/') {
               junit 'tests/testReleaseUnitTest/*.html'
               junit 'tests/testDebugUnitTest/*.html'
               junit '*.xml'
               junit '*.html'
            }
        }
      }
  }
} 