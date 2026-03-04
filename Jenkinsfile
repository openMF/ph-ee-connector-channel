pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
                sh 'mvn -U clean package'
            }
        }
        
        stage('docker build and push') {
            steps {
                sh 'docker build . -t paymenthubee.azurecr.io/phee/connector-channel'
                sh 'docker push paymenthubee.azurecr.io/phee/connector-channel'
            }
        }
    }
}
