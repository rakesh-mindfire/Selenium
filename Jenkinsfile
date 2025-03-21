pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                build 'Build Job'
            }
        }
        stage('Deployment') {
            steps {
                build 'Deployment Job'
            }
        }
        stage('Smoke testing') {
            steps {
                build 'Freestyle_Selenium'
               
            }
        }
        stage('Regression Testing'){
            steps{
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                build 'Selenium Project'
                }
            }
        }
        stage('Completed'){
            steps{
                sleep(5)
                echo 'Completed'
                
            }
        }
    }
}
