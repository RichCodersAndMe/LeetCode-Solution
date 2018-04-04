# 库维护须知

请大家遵守规范，勤加维护。对规范有异议可以提出意见，经过讨论，并落地合理的规范。

## 目录
- [文档编写规范](#文档编写规范)
- [commit信息提交规范](#commit信息提交规范)
- [添加新语言代码](#添加新语言代码)
- [其他常见问题](#其他常见问题)

## 文档编写规范    
 举例说明:  
 当提交首页表格未收录的题目时:   
  - 1 需提交对应解题代码->`./src/_xxx/xxx.yyy`
  - 2 对应的题目题解markdown文件(此文件填写规范参看[题解模板][template])->`./tips/_xxx/README.md`
  - 3 在首页`README.md`对应的位置添加记录   
     - 3.1 根据题目难度(Easy、Medium、Hard),在对应的表格内的对应位置(根据题号排序)添加行  
     - 3.2 添加原题地址（[xxx-question]: https://leetcode.com/problems/xxxxx）  
     - 3.3 添加题解地址 ([xxx-tips]: ./tips/xxx/README.md)  
     - 3.4 添加代码地址 ([xxx-yyy]: ./src/_xxx/Solution.yyy)  
       (注: 同名的kotlin与Java类在同一个目录下会冲突,故kotlin放在更深一层的`kotlin`文件夹中)
       
 总而言之三步走: **代码**、**题解**、**首页README.md**

## commit信息提交规范
> feat：提交新的AC代码  
> fix：修补bug  
> docs：文档修改  
> style： 格式（不影响代码运行的变动）  
> refactor：重构（即不是新增功能，也不是修改bug的代码变动）  
> test：增加测试  
> chore：构建过程或辅助工具的变动  

基本可以按照上述情况对号入座, 还是不明白的参看*历史提交记录*(`git log`)。

commit前先pull, 尽量避免不必要的git分叉.  

commit信息模板: ``feat: add solution of `Two Sum`(001) with Java``


## 添加新语言代码
目前已使用的代码有: `Java`、`JavaScript`、`kotlin`
添加新的语言的解题代码, 请按**字母序**排列，在**对应列**添加解题代码且附链接，文档编写相关细节参看[commit信息提交规范](#commit信息提交规范)。


## 其他常见问题
### 1 同题的同种语言的代码如何处理？
  - 首页README.md使用优先解答的代码链接；
  - 如果同语言代码思路不同可以在**题解文档内**阐述思路,若思路相同，则不再赘述。
  - 文件名则改为: `Solution1.java`、`Solution2.java`、`Solution3.java`,以此类推。

[template]: ./tips/Template.md