package com.perficient.trainingsystem.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perficient.trainingsystem.exception.CompanyException;
import com.perficient.trainingsystem.model.Company;
import com.perficient.trainingsystem.model.Course;
import com.perficient.trainingsystem.repository.CompanyRepository;
import com.perficient.trainingsystem.repository.CourseRepository;
import com.perficient.trainingsystem.service.UserSearchService;
import com.perficient.trainingsystem.utils.ImageUtilDateBase;

@Service
public class UserSearchServiceImpl implements UserSearchService {
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private CourseRepository courseRepository;

	private static final Logger logger = LoggerFactory.getLogger(ImageUtilDateBase.class);
	private Map<Company, List<Course>> map;
	private List<Course> l;

	
	private static Integer SORTBYPOPULARITY = 1;
	
	public Map<Company, List<Course>> userSearchInfoByKey(String key) throws CompanyException {
		List<Company> listComp;
		List<Course> lc;
		List<String> ls= new ArrayList<String>();
		map = new HashMap<Company, List<Course>>();
		String[] str = key.split(" ");
		listComp = companyRepository.findAll();
		Iterator<Company> it = listComp.iterator();
		while (it.hasNext()) {
			Company c = it.next();
			String id = c.getId();
			lc = courseRepository.findByCompanyId(id);
			if (lc.size() > 0) {
				for (int j = 0; j < lc.size(); j++) {
					String str1 = c.getName() + "," + lc.get(j).getId() + "," + lc.get(j).getCourseName()
							+ "," + lc.get(j).getSuitableCrowd() + "," + lc.get(j).getType();
					ls.add(str1);
				}
			} else {
				String s1 = c.getName();
				ls.add(s1);
			}
		}
		for (int k = ls.size() - 1; k >= 0; k--) {
			String[] s4 = ls.get(k).split(",");
			String s5 = "";
			for (int m = 0; m < s4.length; m++) {
				if (m != 1) {
					s5 += "," + s4[m];
				}
			}
			for (int l = 0; l < str.length; l++) {
				if (!s5.toLowerCase().contains(str[l].toLowerCase())) {
					ls.remove(k);
					break;
				}
			}
		}
		for (String s2 : ls) {
			l = new ArrayList<Course>();
			String[] s3 = s2.split(",");
			Company c = companyRepository.findByName(s3[0]);
			if (s3.length <= 1) {
				l.add(null);
			} else {
				l = courseRepository.findById(s3[1]);
			}
			if (map.containsKey(c)) {
				map.get(c).add(l.get(0));
			} else {
				map.put(c, l);
			}
		}
		return map;
	}

	public Map<Company, List<Course>> userFilterByKeys(String[] fk, String searchK) throws CompanyException {
		map = userSearchInfoByKey(searchK);
		
		String s="";
		for(int i = 0; i<3; i++) {
			s = s.concat(fk[i]);
		}
		if(s==null || s.trim().equals(""))
			return map;
		
		//filter address
		logger.info("map.size======before======"+map.size());
		Iterator<Map.Entry<Company, List<Course>>> it = map.entrySet().iterator(); 
        while(it.hasNext()){  
            Map.Entry<Company, List<Course>> entry = it.next();
            if(!entry.getKey().getAddress().contains(fk[2].trim()))  
                it.remove();
        }
        logger.info("map.size======address======"+map.size());
        
        //filter type suit
        it = map.entrySet().iterator();
        while (it.hasNext()) {
        	Map.Entry<Company, List<Course>> entry = it.next();
        	if(entry.getValue() == null || entry.getValue().get(0) == null) {
        		it.remove();
        		continue;
        	}
        	List<Course> courses = entry.getValue();
        	Iterator<Course> itc = courses.iterator();
        	while (itc.hasNext()) {
        		Course course = itc.next();
        		String ts = course.getType() + " " +course.getSuitableCrowd();
        		if( !ts.contains(fk[0]) || !ts.contains(fk[1])) itc.remove();
			}
        	if(courses==null || courses.isEmpty() || courses.size()==0 || courses.get(0) == null) {
        		it.remove();
        	}
		}
        logger.info("map.size======type.etc======"+map.size());
		return map;
	}

	public Map<Company, List<Course>> userSortKey(String[] filterK, String searchK, Integer sort)
			throws CompanyException {

		map = userSort(filterK, searchK, sort);

		return map;
	}

	private Map<Company, List<Course>> userSort(String[] filterK, String searchK, final Integer sort)
			throws CompanyException {
		map = this.userFilterByKeys(filterK, searchK);
		Map<Company, List<Course>> newMap = new TreeMap<Company, List<Course>>(new Comparator<Company>() {
			public int compare(Company o1, Company o2) {
				if (sort == SORTBYPOPULARITY) {
					Integer compare = Integer.valueOf(o2.getPopularity())
							.compareTo(Integer.valueOf(o1.getPopularity()));
					if (compare >= 0)
						return 1;
					else
						return -1;

				} else {
					Integer compare = Double.valueOf(o2.getScore()).compareTo(Double.valueOf(o1.getScore()));
					if (compare >= 0)
						return 1;
					else
						return -1;

				}
			}
		});
		Set<Entry<Company, List<Course>>> entry = map.entrySet();
		Iterator<Entry<Company, List<Course>>> iter = entry.iterator();
		while (iter.hasNext()) {
			Entry<Company, List<Course>> next = iter.next();
			newMap.put(next.getKey(), next.getValue());
		}
		return newMap;
	}
}