package soongni.control.json;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import soongni.domain.BusiMember;
import soongni.service.BrandService;
import soongni.service.BusiMemberService;

@RestController
@RequestMapping("/busimember/")
public class BusiMemberControl {
  
  @Autowired ServletContext servletContext;
  @Autowired BrandService brandService;
  @Autowired BusiMemberService busiMemberService;
  
  @RequestMapping("list")
  public JsonResult list(
      @RequestParam(defaultValue="1") int pageNo, 
      @RequestParam(defaultValue="5") int pageSize) throws Exception {
    
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("list", busiMemberService.list(pageNo, pageSize));
   
    
    return new JsonResult(JsonResult.SUCCESS, dataMap);
  }
  
  @RequestMapping("brandMemberBrand")
  public JsonResult brandMemberBrand(int ceono) throws Exception {

	  BusiMember busiMember = busiMemberService.brandMemberBrand(ceono);
	  if (busiMember == null) {
        return new JsonResult(JsonResult.FAIL, ceono);
      }
    return new JsonResult(JsonResult.SUCCESS, busiMember);
  }
  
  
  @RequestMapping(value="add", method=RequestMethod.POST)
  public JsonResult add(BusiMember busiMember) throws Exception {
    busiMemberService.add(busiMember);
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  
  /*@RequestMapping("detail")
  public JsonResult detail(int no) throws Exception {
    Code code = codeService.get(no);
    if (code == null) {
      return new JsonResult(JsonResult.FAIL, no + "번 강사가 없습니다.");
    }
    return new JsonResult(JsonResult.SUCCESS, code);
  }
  
  @RequestMapping("update")
  public JsonResult update(Code code) throws Exception {
    codeService.update(code);
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  
  @RequestMapping("delete")
  public JsonResult delete(int no) throws Exception {
	  codeService.remove(no);
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }  
 */
 
  /*@RequestMapping("upload")
  public JsonResult upload(MultipartFile[] files) throws Exception {
    ArrayList<String> fileList = new ArrayList<>();
    for (MultipartFile file : files) {
      if (file.isEmpty())
        continue;
      String filename = getNewFilename();
      file.transferTo(new File(servletContext.getRealPath("/teacher/photo/" + filename)));
      fileList.add(filename);
    }
    return new JsonResult(JsonResult.SUCCESS, fileList);
  }
  
  int count = 0;
  synchronized private String getNewFilename() {
    if (count > 100) {
      count = 0;
    }
    return String.format("%d_%d", System.currentTimeMillis(), ++count); 
  }*/
}









