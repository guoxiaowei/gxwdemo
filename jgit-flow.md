#feature
	mvn jgitflow:feature-start -DfeatureName=sales_return -DpushFeatures=true
	mvn jgitflow:feature-finish -DfeatureName=sales_return -DnoFeatureBuild=true -DpushFeatures=true

#release 
	mvn jgitflow:release-start -DreleaseVersion=1.1.0 -DdevelopmentVersion=1.2.0-SNAPSHOT -DpushReleases=true
	mvn jgitflow:release-finish -DnoReleaseBuild=true -DnoDeploy=true -DpushReleases=true

#hotfix
	mvn jgitflow:hotfix-start -DreleaseVersion=1.2.1 -DpushHotfixes=true
	mvn jgitflow:hotfix-finish -DnoHotfixBuild=true -DnoDeploy=true -DpushHotfixes=true
-------------