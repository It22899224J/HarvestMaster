package com.Backend.HarvestMaster.FAQ.Service;

import com.Backend.HarvestMaster.FAQ.Model.FAQ;

import java.util.List;

public interface FAQService {

    public FAQ addFaq (FAQ faq);
    public FAQ getSelectedFaq (int faq_id);

    public List<FAQ>  getAllFaqs ();
    public boolean removeFaq (int faq_id);



}
