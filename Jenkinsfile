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
    stage('testStagingDebug'){
      steps{
        script {
          try {
            sh './gradlew testStagingDebug'
          } catch (Exception e) {
            echo e.getMessage()
            echo "test failed"
          }
        }       
      }   
    }
    stage('testReleaseDebug'){
      steps{
        script {
          try {
            sh './gradlew testReleaseDebug'
          } catch (Exception e) {
            echo e.getMessage()
            echo "test failed"
          }
        }       
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
  }
} 