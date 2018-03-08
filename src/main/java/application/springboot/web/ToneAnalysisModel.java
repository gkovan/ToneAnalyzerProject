/**
 * 
 */
package application.springboot.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class ToneAnalysisModel {
    public final Sentences_tone sentences_tone[];

    @JsonCreator
    public ToneAnalysisModel(@JsonProperty("sentences_tone") Sentences_tone[] sentences_tone){
        this.sentences_tone = sentences_tone;
    }

    public static final class Sentences_tone {
        public final long sentence_id;
        public final String text;
        public final Tone tones[];

        @JsonCreator
        public Sentences_tone(@JsonProperty("sentence_id") long sentence_id, @JsonProperty("text") String text, @JsonProperty("tones") Tone[] tones){
            this.sentence_id = sentence_id;
            this.text = text;
            this.tones = tones;
        }

        public static final class Tone {
            public final double score;
            public final String tone_id;
            public final String tone_name;
    
            @JsonCreator
            public Tone(@JsonProperty("score") double score, @JsonProperty("tone_id") String tone_id, @JsonProperty("tone_name") String tone_name){
                this.score = score;
                this.tone_id = tone_id;
                this.tone_name = tone_name;
            }
        }
    }
}
