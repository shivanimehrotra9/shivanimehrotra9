def REPOSITORY_NAME = scm.getUserRemoteConfigs()[0].getUrl().tokenize('/').last().split("\\.")[0]
def SLACK_CHANNEL = "hagrid-airflow"

def dummy_pr = 1
pipeline{
    environment {
        BRANCH_NAME = "${GIT_BRANCH.split("/")[1]}"
    }
    agent any
    stages{
        stage("Details"){
            steps{
                echo "========executing Details========"
                echo "******************** Details ********************"
                echo "REPOSITORY NAME: $REPOSITORY_NAME"
                echo "BRANCH NAME: ${BRANCH_NAME}"
                echo "TRIGGERED BY PR: ${env.CHANGE_ID}"
                echo "SLACK CHANNEL: $SLACK_CHANNEL"

            }
        }

        stage("Get the list of Changed Files"){
            steps{
                echo "******************** List of files changed in this PR: ${env.CHANGE_ID} ********************"
                sh 'git --no-pager diff origin/check/pr_changed_files --name-only'

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