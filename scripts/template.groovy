node {
   stage 'Checkout'
   // Get some code from repository

   stage 'Build'
   // Run the build
}

stage 'deployment'
input 'Do you approve deployment?'
node {
    //deploy things
    def tasks = [:]

    tasks["task_1"] = {
        stage ("task_1"){    
            node {  
            sh 'echo $NODE_NAME'
        }
    }
    }
    tasks["task_2"] = {
    stage ("task_2"){    
        node {  
            sh 'echo $NODE_NAME'
        }
    }
    }

parallel tasks
}
