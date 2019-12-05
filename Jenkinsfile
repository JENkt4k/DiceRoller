pipeline {
  agent { docker { image 'circleci/android:api-29-node' } }
  stages {
    stage('build') {
      steps {
          sh './gradlew'
      }
    }
    stage('Lint and Unit Test'){
    parallel {
    stage('check'){
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
    stage('test'){
      steps{
        script {
          try {
            sh './gradlew test'
          } catch (Exception e) {
            echo e.getMessage()
            echo "test failed"
          }
        }       
      }   
    }
    stage('testDebugUnitTest'){
      steps{
        script {
          try {
            sh './gradlew testDebugUnitTest'
          } catch (Exception e) {
            echo e.getMessage()
            echo "testDebugUnitTest failed"
          }
        }       
      }   
    }
    stage('testReleaseUnitTest'){
      steps{
        script {
          try {
            sh './gradlew testReleaseUnitTest'
          } catch (Exception e) {
            echo e.getMessage()
            echo "testReleaseUnitTest failed"
          }
        }       
      }   
    }
    }
    post {
        always {
          archiveArtifacts 'app/build/outputs/apk/*'
          junit 'app/build/test-results/**/*.xml'
          androidLint canComputeNew: false, defaultEncoding: '', healthy: '', pattern: 'app/build/reports/**/*', unHealthy: ''
        }
        cleanup{
        script {
          try {
            deleteDir('app/build/test-results/')
          } catch (Exception e) {
            echo e.getMessage()
            echo "deleteDir failed"
          }
        }
        }
      }
    }
  }
} 