pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat './gradlew.bat clean testClasses'
            }
        }
        stage('cleanDb') {
           steps {
               bat './gradlew.bat flywayClean -P flyway.user=bib -P flyway.password=password -P flyway.schemas=orders -P flyway.url=jdbc:mysql://localhost:3306/orders'
               bat './gradlew.bat flywayMigrate -P flyway.user=bib -P flyway.password=password -P flyway.schemas=orders -P flyway.url=jdbc:mysql://localhost:3306/orders'
               bat './gradlew.bat flywayClean -P flyway.user=bib -P flyway.password=password -P flyway.schemas=supplier -P flyway.url=jdbc:mysql://localhost:3306/orders'
               bat './gradlew.bat flywayMigrate -P flyway.user=bib -P flyway.password=password -P flyway.schemas=supplier -P flyway.url=jdbc:mysql://localhost:3306/orders'
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
    }

    post {
        always {
            junit '**/build/test-results/test/*.xml'
            step( [ $class: 'JacocoPublisher' ] )
        }
    }
}