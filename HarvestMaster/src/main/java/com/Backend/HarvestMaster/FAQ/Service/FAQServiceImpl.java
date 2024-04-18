package com.Backend.HarvestMaster.FAQ.Service;

import com.Backend.HarvestMaster.FAQ.Model.FAQ;
import com.Backend.HarvestMaster.FAQ.Repository.FaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FAQServiceImpl implements FAQService {



    @Autowired
    private FaqRepository faqRepository;
    @Override
    public FAQ addFaq(FAQ faqdata) {



        return faqRepository.save(faqdata);
    }

    @Override
    public FAQ getSelectedFaq(int faqid) {
        return faqRepository.findById(faqid).get();
    }

    @Override
    public List<FAQ> getAllFaqs() {
        return faqRepository.findAll();
    }

    @Override
    public boolean removeFaq(int faq_id) {
         faqRepository.deleteById(faq_id);
         return true;
    }
}
