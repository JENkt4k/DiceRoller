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
            archiveArtifacts 'app/build/reports/**/*.xml'
            archiveArtifacts 'app/build/reports/**/*.html'
            androidLint canComputeNew: false, defaultEncoding: '', healthy: '', pattern: 'app/build/reports/**/*', unHealthy: ''
        }
      }
    }
    stage('test'){
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
      post {
        always {
          junit 'app/build/reports/tests/**/*.xml'
        }
      }
    }
  }
} 