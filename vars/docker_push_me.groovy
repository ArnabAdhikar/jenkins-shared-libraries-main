def call(String Project, String imageName, String dockerhubpass) {
    withCredentials([usernamePassword(
                    credentialsId:"DockerHubCreds",
                    usernameVariable:"DockerHubUser", 
                    passwordVariable:"DockerHubPass")]){
                sh 'docker login -u ${env.DockerHubUser} -p ${env.DockerHubPass}'
                sh "docker image tag notes-app:latest ${env.DockerHubUser}/notes-app:latest"
                sh "docker push ${env.DockerHubUser}/notes-app:latest"
                echo "Done..."
    }
}
