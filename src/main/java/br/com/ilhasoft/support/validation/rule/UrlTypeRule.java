package br.com.ilhasoft.support.validation.rule;

import android.webkit.URLUtil;
import android.widget.TextView;

import br.com.ilhasoft.support.validation.R;
import br.com.ilhasoft.support.validation.util.EditTextHandler;

/**
 * Created by john-mac on 5/14/16.
 */
public class UrlTypeRule extends TypeRule {

    public UrlTypeRule() {
        super(FieldType.Url);
    }

    @Override
    protected boolean isValid(TextView view) {
        return URLUtil.isValidUrl(view.getText().toString());
    }

    @Override
    protected void onValidationSucceeded(TextView view) {
        super.onValidationSucceeded(view);
        EditTextHandler.removeError(view);
    }

    @Override
    protected void onValidationFailed(TextView view) {
        super.onValidationFailed(view);
        EditTextHandler.setError(view, view.getContext().getString(R.string.error_message_url_validation));
    }
}