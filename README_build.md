# build and run application

## build

### standard build 
    ./gradlew build
    
### force build all
    ./gradlew clean build
    
    
### run application from console
    ./gradlew bootRun  
    
### run application from console and integrate block element without mapping implementation
    ./gradlew bootRun -Dadd.not.implemented.map.method=true  
    