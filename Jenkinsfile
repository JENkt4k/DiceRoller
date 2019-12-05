pipeline {
  agent { docker { image 'circleci/android:api-29-node' } }
  stages {
    stage('build') {
      steps {
          sh './gradlew'
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
            junit 'app/build/test-results/**/*.xml'
            androidLint canComputeNew: false, defaultEncoding: '', healthy: '', pattern: 'app/build/reports/**/*', unHealthy: ''
        }
      }
    }
    stage('debug'){
      steps{
        script {
          try {
            sh './gradlew test'
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
    stage('PublishJuint'){
      steps{
        sh 'ls app/build/test-results/'
      }
      post {
        always {
          archiveArtifacts 'app/build/reports/**/*'
          archiveArtifacts 'app/build/test-results/**/*'
          junit 'app/build/test-results/**/*.xml'
        }
      }
    }
  }
} 