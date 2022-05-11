def REPOSITORY_NAME = scm.getUserRemoteConfigs()[0].getUrl().tokenize('/').last().split("\\.")[0]
def SLACK_CHANNEL = "hagrid-airflow"
def dummy_pr = 1
def github_api_call
pipeline{
    agent any
    stages{
        stage("Details"){
            steps{
                echo "========executing Details========"
                echo "******************** Details ********************"
                echo "REPOSITORY NAME: $REPOSITORY_NAME"
                echo "BRANCH NAME: ${env.BRANCH_NAME}"
                echo "TRIGGERED BY PR: ${env.CHANGE_ID}"
                echo "SLACK CHANNEL: $SLACK_CHANNEL"

            }
        }

        stage("Get the list of Changed Files"){
            steps{
                echo "******************** List of files changed in this PR: ${env.CHANGE_ID} ********************"
                sh 'git --no-pager diff origin/main --name-only'


            }
        }

        stage("Load Groovy file") {
            steps{
                github_api_call = load 'test-github-api.groovy'
                github_api_call.get_changed_files()
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