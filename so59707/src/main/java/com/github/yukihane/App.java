package com.github.yukihane;

import com.worksap.nlp.sudachi.Dictionary;
import com.worksap.nlp.sudachi.DictionaryFactory;
import com.worksap.nlp.sudachi.Morpheme;
import com.worksap.nlp.sudachi.Tokenizer;
import java.io.IOException;
import java.util.List;

public class App {

    public static void main(final String[] args) throws IOException {
        try (final Dictionary dic = new DictionaryFactory().create()) {
            final Tokenizer tokenizer = dic.create();
            final List<Morpheme> morphemes = tokenizer
                    .tokenize("systemDictにファイル名でなくクラスパスからの相対パスでリソース名を指定するように変更したすだちです");

            for (final Morpheme m : morphemes) {
                System.out.printf("%s\t%s\t%s\n", m.surface(), m.partOfSpeech(), m.normalizedForm());
            }
        }
    }
}
