node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/DushyantanFramework/AppiumFramework.git'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'MVN'
      env.PATH = "${mvnHome}/bin:${env.PATH}"
   }
   stage('Build') {
        dir("AppiumFramework"){
        bat 'mvn clean verify'
        }
   }
   stage('Run'){
       dir("AppiumFramework"){
           bat 'mvn compile exec:java -Dexec.mainClass="AutomationDriver" -Dexec.cleanupDaemonThreads=false'
       }
       
   }
   
}
