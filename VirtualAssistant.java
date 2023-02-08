public class VirtualAssistant{
    int assistant_id;
    String assistant_name;
    String assistant_voice;
    VirtualAssistant(String assistant_name, String assistant_voice, int assistant_id){
        this.assistant_id = assistant_id;
        this.assistant_name = assistant_name; 
        this.assistant_voice = assistant_voice;
    }
    String getAssistantName(){
        return this.assistant_name;
    }
    String getAssistantVoice(){
        return this.assistant_voice;
    }
    int getAssistantid(){
        return this.assistant_id;
    }
}