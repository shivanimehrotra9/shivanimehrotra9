def REPOSITORY_NAME = scm.getUserRemoteConfigs()[0].getUrl().tokenize('/').last().split("\\.")[0]
def SLACK_CHANNEL = "hagrid-airflow"
pipeline{
    agent any
    stages{
        stage("Details"){
            steps{
                echo "========executing Details========"
                echo "******************** Details ********************"
                echo "REPOSITORY NAME: $REPOSITORY_NAME"
                echo "BRANCH NAME: ${env.BRANCH_NAME}"
                echo "TRIGGERED BY PR: ${CHANGE_ID}"
                echo "SLACK CHANNEL: $SLACK_CHANNEL"

            }
            post{
                always{
                    echo "========always========"
                }
                success{
                    echo "========A executed successfully========"
                }
                failure{
                    echo "========A execution failed========"
                }
            }
        }

        stage("Get the list of Changed Files"){
            steps{
                echo "******************** List of files changed in this PR: ${CHANGE_ID} ********************"
                

            }
            post{
                always{
                    echo "========always========"
                }
                success{
                    echo "========A executed successfully========"
                }
                failure{
                    echo "========A execution failed========"
                }
            }
        }
    }
    post{
        always{
            echo "========always========"
        }
        success{
            echo "========pipeline executed successfully ========"
        }
        failure{
            echo "========pipeline execution failed========"
        }
    }
}