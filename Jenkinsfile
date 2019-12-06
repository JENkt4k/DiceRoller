pipeline {
  agent { docker { image 'circleci/android:api-29-node' } }
  stages {
    stage('find_anddroid'){
      steps{
        sh 'find -iname android'
        echo 'find -iname android'
      }
    }
    stage('adb_connect'){
      steps{
        sh 'find -iname android'
        sh 'adb kill-server'
        sh 'adb start-server'
        sh 'adb devices'
        sh 'adb connect 192.168.1.36:5555'
      }
    } 
    stage('build') {
      steps {
          sh './gradlew'
      }
    }
    stage('Lint and Unit Test'){
      parallel {
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
      }
    }
    stage('createAPK'){
      steps{
        sh './gradlew assembleRelease'  
      }
    }
  }
  post {
    always {            
      junit 'app/build/test-results/**/*.xml'
      androidLint canComputeNew: false, defaultEncoding: '', healthy: '', pattern: 'app/build/reports/**/*', unHealthy: ''
      archiveArtifacts 'app/build/outputs/apk/**/*.apk'
      dir('app/build/test-results'){ 
        deleteDir()
      }
      
    }
  }
} 