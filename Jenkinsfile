pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
                sh 'mvn -U clean package'
            }
        }
    }
}