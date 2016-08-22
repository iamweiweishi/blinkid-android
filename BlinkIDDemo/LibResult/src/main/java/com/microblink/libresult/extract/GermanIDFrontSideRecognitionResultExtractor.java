package com.microblink.libresult.extract;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.austria.front.AustrianIDFrontSideRecognitionResult;
import com.microblink.recognizers.blinkid.germany.front.GermanIDFrontSideRecognitionResult;

import java.util.List;

public class GermanIDFrontSideRecognitionResultExtractor extends BlinkOcrRecognitionResultExtractor {
    public GermanIDFrontSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof GermanIDFrontSideRecognitionResult) {
            GermanIDFrontSideRecognitionResult deIdFrontResult = (GermanIDFrontSideRecognitionResult) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPLastName,
                    deIdFrontResult.getLastName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPFirstName,
                    deIdFrontResult.getFirstName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDocumentNumber,
                    deIdFrontResult.getIdentityCardNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    deIdFrontResult.getDateOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPNationality,
                    deIdFrontResult.getNationality()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPPlaceOfBirth,
                    deIdFrontResult.getPlaceOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfExpiry,
                    deIdFrontResult.getDateOfExpiry()
            ));
        }

        return mExtractedData;
    }
}
