pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat './gradlew.bat clean testClasses'
                bat './gradlew.bat war'
            }
        }
        stage('cleanDb') {
           steps {
               bat './gradlew.bat :Order:flywayClean -P flyway.user=bib -P flyway.password=password -P flyway.schemas=orders -P flyway.url=jdbc:mysql://localhost:3306/orders'
               bat './gradlew.bat :Order:flywayMigrate -P flyway.user=bib -P flyway.password=password -P flyway.schemas=orders -P flyway.url=jdbc:mysql://localhost:3306/orders'
               bat './gradlew.bat :Supplier:flywayClean -P flyway.user=bib -P flyway.password=password -P flyway.schemas=supplier -P flyway.url=jdbc:mysql://localhost:3306/supplier'
               bat './gradlew.bat :Supplier:flywayMigrate -P flyway.user=bib -P flyway.password=password -P flyway.schemas=supplier -P flyway.url=jdbc:mysql://localhost:3306/supplier'
           }
        }

        stage('Test') {
            steps {
                bat(script: './gradlew.bat test -P springProfiles=jenkins', returnStatus:true)
            }
        }

        stage('CodeCoverage') {
            steps {
                script {
                    try {
                        bat './gradlew.bat jacocoTestCoverageVerification'
                    } catch(error) {
                        currentBuild.result='UNSTABLE'
                    }
                }
            }
        }

        stage('ArchiveArtifacts'){
            steps {
                archiveArtifacts artifacts: '**/build/libs/*.war', fingerprint: true
            }
        }
    }

    post {
        always {
            junit '**/build/test-results/test/*.xml'
            step( [ $class: 'JacocoPublisher' ] )
        }
    }
}