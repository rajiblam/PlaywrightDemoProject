pipeline 
{
    agent any
    
    tools{
    	maven 'maven 3.9.8'
        }

    stages 
    {
        stage('Build') 
        {
            steps
            {
                 git 'https://github.com/jglick/simple-maven-project-with-tests.git'
                 sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }
            post 
            {
                success
                {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        stage("Deploy to QA"){
            steps{
                echo("deploy to qa")
            }
        }
                
        stage('Regression Automation Test') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    git 'https://github.com/rajiblam/PlaywrightDemoProject'
                    sh "mvn clean test -Dsurefire.suiteXmlFiles=ParallelExecution.xml"
                    
                }
            }
        }
        
        
        stage('Publish Extent Report'){
            steps{
                     publishHTML([allowMissing: false,
                                  alwaysLinkToLastBuild: false, 
                                  keepAll: true, 
                                  reportDir: 'test-output', 
                                  reportFiles: 'index.html', 
                                  reportName: 'HTML  Report', 
                                  reportTitles: ''])
            }
        }
        
        
        
        
    }
}