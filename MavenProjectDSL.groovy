<!--https://jenkinsci.github.io/job-dsl-plugin/
--!>
job('First-Maven-Project-Via-DSL') {
    description("First Maven job generated by the DSL on ${new Date()}, the project is a small Maven project hosted on github")
    scm {
        git("https://github.com/sushilparab/Jenkins_Upgradev3.git", 'master') { node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('sushilparab')
            node / gitConfigEmail('sushil.parab@orbit.de') 
        }
    }
    triggers {
        scm('* * * * *')
    }
    steps {
        maven('clean package', 'maven-samples/single-module/pom.xml')
    }
    publishers {
        //archive the war file generated
        archiveArtifacts '**/*.jar'
    }
}