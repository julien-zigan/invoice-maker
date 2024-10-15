package InvoiceMaker.businesslogic;

import java.io.File;

public class EinsatzbestaetigungBuilder {
    static StringBuilder fullText;

    public static Einsatzbestaetigung build(File file) {
        Einsatzbestaetigung einsatzbestaetigung = new Einsatzbestaetigung();

        try {
            fullText = TextExtractor.extract(file);

            String recipientStartKey = "Rechnung an:";
            String recipientEndKey = "Bemerkungen";
            int recipientStartPos = fullText.indexOf(recipientStartKey) + recipientStartKey.length() + 1;
            int recipientEndPos = fullText.indexOf(recipientEndKey) - 2;
            Recipient recipient = new Recipient();
            String interimText = fullText.substring(recipientStartPos, recipientEndPos);
            recipient.testrecip = RecipientCompositor.compose(interimText);
            einsatzbestaetigung.setRecipient(recipient);

            String auftragsNrKeyword = "Auftrags-Nr.";
            String wordSeparator = "\r\n";
            int auftragsNrStartPos = fullText.indexOf(auftragsNrKeyword) + auftragsNrKeyword.length() + 1;
            int auftragsNrEndPos = fullText.indexOf(wordSeparator, auftragsNrStartPos);

            AuftragsNr auftragsNr = new AuftragsNr(
                    Integer.parseInt(
                    fullText.substring(auftragsNrStartPos, auftragsNrEndPos)
                    )
            );

            einsatzbestaetigung.setAuftragsNr(auftragsNr); //TODO try to convert Design into usage of add() methods



        } catch (Exception e) {
            System.err.println(e);
        }

        return einsatzbestaetigung;
    }
}
