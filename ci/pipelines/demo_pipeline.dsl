pipeline {
    agent any
    tools {
        maven "M3"
        //JDK optional
    }

    stages {
        stage("Checkout") {
            steps {
                git branch: 'main',url:"https://github.com/SpringTechie/CRUDOperation.git"
            }

        }
        stage("Compile") {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage("Build") {
            steps {
                sh 'mvn install'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
        }
    }
}