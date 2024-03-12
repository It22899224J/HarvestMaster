package com.Backend.HarvestMaster.FAQ.Service;

import com.Backend.HarvestMaster.FAQ.Model.FAQ;

import java.util.List;

public interface FAQService {

    public FAQ addFaq (FAQ faq);
    public FAQ getFaq (int faq_id);

    public List<FAQ>  getAllFaq ();
    public boolean removeFaq (int faq_id);



}
