import groovy.json.JsonSlurper

def get_changed_files() {

    url = "https://api.github.com/repos/shivanimehrotra9/shivanimehrotra9/pulls/2/files"
    try {
        // Set requirements for the HTTP GET request, you can add Content-Type headers and so on...
        def http_client = new URL(url).openConnection() as HttpURLConnection
        http_client.setRequestMethod("GET")
        http_client.setRequestProperty("Authorization","token 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")
        http_client.setRequestProperty("Accept","application/vnd.github.v3+json")
        // Run the HTTP request
        http_client.connect()
        // Prepare a variable where we save parsed JSON as a HashMap, it\'s good for our use case, as we just need the \'name\' of each tag.
        def dockerhub_response = null
        // Check if we got HTTP 200, otherwise exit
        if (http_client.responseCode == 200) {
            response = new JsonSlurper().parseText(http_client.inputStream.getText("UTF-8"))
            println(response)
            println("**************************************")
        } else {
            println("HTTP response error")
        }
        // Prepare a List to collect the tag names into
        def models = []
        // Iterate the HashMap of all Tags and grab only their "names" into our List
        response.each { dir ->
            //if (!dir.name.equalsIgnoreCase(".gitignore") && !dir.name.equalsIgnoreCase("README.md")){
            //models.add(dir.name)
            if (!dir.status.equalsIgnoreCase("removed")) {
                println(dir.filename)
            }
        }
        
        println(models.sort())
        // The returned value MUST be a Groovy type of List or a related type (inherited from List)
        // It is necessary for the Active Choice plugin to display results in a combo-box
        return models.sort()
    } catch (Exception e) {
            // handle exceptions like timeout, connection errors, etc.
            println(e)
    }
    return this;
}