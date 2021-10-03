node(){
    
    def template = load("${env.WORKSPACE}/scripts/template.groovy")
    
    currentBuild.result = "SUCCESS"
    
    try{
        stage('checkout'){
            checout scm
        }
         stage ('Development') {
             steps {
                script {template('desarrollo')}
              }
                }
         stage ('Staging') {
             steps {
                script {template('stagin')}
                    }
                }
         stage ('Production') {
             steps {
                script {template('main')}
                    }
        
    }
        catch (err){
            currentBuild.result = "FALURE"
            throw err
        }
}
