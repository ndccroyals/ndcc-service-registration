@Library("ndcc-shared-lib") _
ndccservice.groovy

/*node {
   def mvnHome
   def gradleHome

   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
		checkout scm
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.
      mvnHome = tool 'M3'
      gradleHome = tool 'gradle'
   }
   stage('Build') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
   }
   stage('gradle build') {
        if (isUnix()){
		//sh "'${gradleHome}/bin/gradle clean build'"
		sh "./gradlew clean build"
		} else {
		   bat(/"${gradleHome}\bin\gradle" clean build/)
		   }
		   }

      junit '---"**"/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
   }
   
<<<<<<< HEAD:jenkinsfile
}*/
=======
}
>>>>>>> 5fa1b0e5c164f9b6e3620279f79ac34492653465:Jenkinsfile
