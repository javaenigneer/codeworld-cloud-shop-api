/*
 Navicat MySQL Data Transfer

 Source Server         : 本地库
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : localhost:3306
 Source Schema         : codeworld-cloud-shop

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 09/03/2021 15:37:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for codeworld_area
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_area`;
CREATE TABLE `codeworld_area`  (
  `t_area_id` int(10) NOT NULL COMMENT '区域id主键',
  `t_area_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `t_parent_id` int(10) NULL DEFAULT NULL COMMENT '父级id',
  `t_area_sort_no` int(10) NULL DEFAULT 1 COMMENT '排序',
  PRIMARY KEY (`t_area_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_area
-- ----------------------------
INSERT INTO `codeworld_area` VALUES (110000, '北京市', 0, 1);
INSERT INTO `codeworld_area` VALUES (110100, '东城区', 110000, 1);
INSERT INTO `codeworld_area` VALUES (110200, '西城区', 110000, 1);
INSERT INTO `codeworld_area` VALUES (110500, '朝阳区', 110000, 1);
INSERT INTO `codeworld_area` VALUES (110600, '丰台区', 110000, 1);
INSERT INTO `codeworld_area` VALUES (110700, '石景山区', 110000, 1);
INSERT INTO `codeworld_area` VALUES (110800, '海淀区', 110000, 1);
INSERT INTO `codeworld_area` VALUES (110900, '门头沟区', 110000, 1);
INSERT INTO `codeworld_area` VALUES (111100, '房山区', 110000, 1);
INSERT INTO `codeworld_area` VALUES (111200, '通州区', 110000, 1);
INSERT INTO `codeworld_area` VALUES (111300, '顺义区', 110000, 1);
INSERT INTO `codeworld_area` VALUES (111400, '昌平区', 110000, 1);
INSERT INTO `codeworld_area` VALUES (111500, '大兴区', 110000, 1);
INSERT INTO `codeworld_area` VALUES (111600, '怀柔区', 110000, 1);
INSERT INTO `codeworld_area` VALUES (111700, '平谷区', 110000, 1);
INSERT INTO `codeworld_area` VALUES (112800, '密云县', 110000, 1);
INSERT INTO `codeworld_area` VALUES (112900, '延庆县', 110000, 1);
INSERT INTO `codeworld_area` VALUES (120000, '天津市', 0, 1);
INSERT INTO `codeworld_area` VALUES (120100, '和平区', 120000, 1);
INSERT INTO `codeworld_area` VALUES (120200, '河东区', 120000, 1);
INSERT INTO `codeworld_area` VALUES (120300, '河西区', 120000, 1);
INSERT INTO `codeworld_area` VALUES (120400, '南开区', 120000, 1);
INSERT INTO `codeworld_area` VALUES (120500, '河北区', 120000, 1);
INSERT INTO `codeworld_area` VALUES (120600, '红桥区', 120000, 1);
INSERT INTO `codeworld_area` VALUES (120900, '滨海新区', 120000, 1);
INSERT INTO `codeworld_area` VALUES (121000, '东丽区', 120000, 1);
INSERT INTO `codeworld_area` VALUES (121100, '西青区', 120000, 1);
INSERT INTO `codeworld_area` VALUES (121200, '津南区', 120000, 1);
INSERT INTO `codeworld_area` VALUES (121300, '北辰区', 120000, 1);
INSERT INTO `codeworld_area` VALUES (121400, '武清区', 120000, 1);
INSERT INTO `codeworld_area` VALUES (121500, '宝坻区', 120000, 1);
INSERT INTO `codeworld_area` VALUES (122100, '宁河县', 120000, 1);
INSERT INTO `codeworld_area` VALUES (122300, '静海县', 120000, 1);
INSERT INTO `codeworld_area` VALUES (122500, '蓟县', 120000, 1);
INSERT INTO `codeworld_area` VALUES (130000, '河北省', 0, 1);
INSERT INTO `codeworld_area` VALUES (130100, '石家庄市', 130000, 1);
INSERT INTO `codeworld_area` VALUES (130101, '市辖区', 130100, 1);
INSERT INTO `codeworld_area` VALUES (130102, '长安区', 130101, 1);
INSERT INTO `codeworld_area` VALUES (130103, '桥东区', 130101, 1);
INSERT INTO `codeworld_area` VALUES (130104, '桥西区', 130101, 1);
INSERT INTO `codeworld_area` VALUES (130105, '新华区', 130101, 1);
INSERT INTO `codeworld_area` VALUES (130107, '井陉矿区', 130101, 1);
INSERT INTO `codeworld_area` VALUES (130108, '裕华区', 130101, 1);
INSERT INTO `codeworld_area` VALUES (130121, '井陉县', 130100, 1);
INSERT INTO `codeworld_area` VALUES (130123, '正定县', 130100, 1);
INSERT INTO `codeworld_area` VALUES (130124, '栾城县', 130100, 1);
INSERT INTO `codeworld_area` VALUES (130125, '行唐县', 130100, 1);
INSERT INTO `codeworld_area` VALUES (130126, '灵寿县', 130100, 1);
INSERT INTO `codeworld_area` VALUES (130127, '高邑县', 130100, 1);
INSERT INTO `codeworld_area` VALUES (130128, '深泽县', 130100, 1);
INSERT INTO `codeworld_area` VALUES (130129, '赞皇县', 130100, 1);
INSERT INTO `codeworld_area` VALUES (130130, '无极县', 130100, 1);
INSERT INTO `codeworld_area` VALUES (130131, '平山县', 130100, 1);
INSERT INTO `codeworld_area` VALUES (130132, '元氏县', 130100, 1);
INSERT INTO `codeworld_area` VALUES (130133, '赵县', 130100, 1);
INSERT INTO `codeworld_area` VALUES (130181, '辛集市', 130100, 1);
INSERT INTO `codeworld_area` VALUES (130182, '藁城市', 130100, 1);
INSERT INTO `codeworld_area` VALUES (130183, '晋州市', 130100, 1);
INSERT INTO `codeworld_area` VALUES (130184, '新乐市', 130100, 1);
INSERT INTO `codeworld_area` VALUES (130185, '鹿泉市', 130100, 1);
INSERT INTO `codeworld_area` VALUES (130200, '唐山市', 130000, 1);
INSERT INTO `codeworld_area` VALUES (130201, '市辖区', 130200, 1);
INSERT INTO `codeworld_area` VALUES (130202, '路南区', 130201, 1);
INSERT INTO `codeworld_area` VALUES (130203, '路北区', 130201, 1);
INSERT INTO `codeworld_area` VALUES (130204, '古冶区', 130201, 1);
INSERT INTO `codeworld_area` VALUES (130205, '开平区', 130201, 1);
INSERT INTO `codeworld_area` VALUES (130207, '丰南区', 130201, 1);
INSERT INTO `codeworld_area` VALUES (130208, '丰润区', 130201, 1);
INSERT INTO `codeworld_area` VALUES (130223, '滦县', 130200, 1);
INSERT INTO `codeworld_area` VALUES (130224, '滦南县', 130200, 1);
INSERT INTO `codeworld_area` VALUES (130225, '乐亭县', 130200, 1);
INSERT INTO `codeworld_area` VALUES (130227, '迁西县', 130200, 1);
INSERT INTO `codeworld_area` VALUES (130229, '玉田县', 130200, 1);
INSERT INTO `codeworld_area` VALUES (130230, '唐海县', 130200, 1);
INSERT INTO `codeworld_area` VALUES (130281, '遵化市', 130200, 1);
INSERT INTO `codeworld_area` VALUES (130283, '迁安市', 130200, 1);
INSERT INTO `codeworld_area` VALUES (130300, '秦皇岛市', 130000, 1);
INSERT INTO `codeworld_area` VALUES (130301, '海港区', 130300, 1);
INSERT INTO `codeworld_area` VALUES (130303, '山海关区', 130300, 1);
INSERT INTO `codeworld_area` VALUES (130304, '北戴河区', 130300, 1);
INSERT INTO `codeworld_area` VALUES (130321, '青龙满族自治县', 130300, 1);
INSERT INTO `codeworld_area` VALUES (130322, '昌黎县', 130300, 1);
INSERT INTO `codeworld_area` VALUES (130323, '抚宁县', 130300, 1);
INSERT INTO `codeworld_area` VALUES (130324, '卢龙县', 130300, 1);
INSERT INTO `codeworld_area` VALUES (130400, '邯郸市', 130000, 1);
INSERT INTO `codeworld_area` VALUES (130401, '市辖区', 130400, 1);
INSERT INTO `codeworld_area` VALUES (130402, '邯山区', 130401, 1);
INSERT INTO `codeworld_area` VALUES (130403, '丛台区', 130401, 1);
INSERT INTO `codeworld_area` VALUES (130404, '复兴区', 130401, 1);
INSERT INTO `codeworld_area` VALUES (130406, '峰峰矿区', 130401, 1);
INSERT INTO `codeworld_area` VALUES (130421, '邯郸县', 130400, 1);
INSERT INTO `codeworld_area` VALUES (130423, '临漳县', 130400, 1);
INSERT INTO `codeworld_area` VALUES (130424, '成安县', 130400, 1);
INSERT INTO `codeworld_area` VALUES (130425, '大名县', 130400, 1);
INSERT INTO `codeworld_area` VALUES (130426, '涉县', 130400, 1);
INSERT INTO `codeworld_area` VALUES (130427, '磁县', 130400, 1);
INSERT INTO `codeworld_area` VALUES (130428, '肥乡县', 130400, 1);
INSERT INTO `codeworld_area` VALUES (130429, '永年县', 130400, 1);
INSERT INTO `codeworld_area` VALUES (130430, '邱县', 130400, 1);
INSERT INTO `codeworld_area` VALUES (130431, '鸡泽县', 130400, 1);
INSERT INTO `codeworld_area` VALUES (130432, '广平县', 130400, 1);
INSERT INTO `codeworld_area` VALUES (130433, '馆陶县', 130400, 1);
INSERT INTO `codeworld_area` VALUES (130434, '魏县', 130400, 1);
INSERT INTO `codeworld_area` VALUES (130435, '曲周县', 130400, 1);
INSERT INTO `codeworld_area` VALUES (130481, '武安市', 130400, 1);
INSERT INTO `codeworld_area` VALUES (130500, '邢台市', 130000, 1);
INSERT INTO `codeworld_area` VALUES (130501, '市辖区', 130500, 1);
INSERT INTO `codeworld_area` VALUES (130502, '桥东区', 130501, 1);
INSERT INTO `codeworld_area` VALUES (130503, '桥西区', 130501, 1);
INSERT INTO `codeworld_area` VALUES (130521, '邢台县', 130500, 1);
INSERT INTO `codeworld_area` VALUES (130522, '临城县', 130500, 1);
INSERT INTO `codeworld_area` VALUES (130523, '内丘县', 130500, 1);
INSERT INTO `codeworld_area` VALUES (130524, '柏乡县', 130500, 1);
INSERT INTO `codeworld_area` VALUES (130525, '隆尧县', 130500, 1);
INSERT INTO `codeworld_area` VALUES (130526, '任县', 130500, 1);
INSERT INTO `codeworld_area` VALUES (130527, '南和县', 130500, 1);
INSERT INTO `codeworld_area` VALUES (130528, '宁晋县', 130500, 1);
INSERT INTO `codeworld_area` VALUES (130529, '巨鹿县', 130529, 1);
INSERT INTO `codeworld_area` VALUES (130530, '新河县', 130500, 1);
INSERT INTO `codeworld_area` VALUES (130531, '广宗县', 130500, 1);
INSERT INTO `codeworld_area` VALUES (130532, '平乡县', 130500, 1);
INSERT INTO `codeworld_area` VALUES (130533, '威县', 130500, 1);
INSERT INTO `codeworld_area` VALUES (130534, '清河县', 130500, 1);
INSERT INTO `codeworld_area` VALUES (130535, '临西县', 130500, 1);
INSERT INTO `codeworld_area` VALUES (130581, '南宫市', 130500, 1);
INSERT INTO `codeworld_area` VALUES (130582, '沙河市', 130500, 1);
INSERT INTO `codeworld_area` VALUES (130600, '保定市', 130000, 1);
INSERT INTO `codeworld_area` VALUES (130601, '新市区', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130603, '北市区', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130604, '南市区', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130621, '满城县', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130622, '清苑县', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130623, '涞水县', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130624, '阜平县', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130625, '徐水县', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130626, '定兴县', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130627, '唐县', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130628, '高阳县', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130629, '容城县', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130630, '涞源县', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130631, '望都县', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130632, '安新县', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130633, '易县', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130634, '曲阳县', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130635, '蠡县', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130636, '顺平县', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130637, '博野县', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130638, '雄县', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130681, '涿州市', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130682, '定州市', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130683, '安国市', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130684, '高碑店市', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130685, '白沟新城县', 130600, 1);
INSERT INTO `codeworld_area` VALUES (130700, '张家口市', 130000, 1);
INSERT INTO `codeworld_area` VALUES (130701, '市辖区', 130700, 1);
INSERT INTO `codeworld_area` VALUES (130702, '桥东区', 130701, 1);
INSERT INTO `codeworld_area` VALUES (130703, '桥西区', 130701, 1);
INSERT INTO `codeworld_area` VALUES (130705, '宣化区', 130701, 1);
INSERT INTO `codeworld_area` VALUES (130706, '下花园区', 130701, 1);
INSERT INTO `codeworld_area` VALUES (130721, '宣化县', 130700, 1);
INSERT INTO `codeworld_area` VALUES (130722, '张北县', 130700, 1);
INSERT INTO `codeworld_area` VALUES (130723, '康保县', 130700, 1);
INSERT INTO `codeworld_area` VALUES (130724, '沽源县', 130700, 1);
INSERT INTO `codeworld_area` VALUES (130725, '尚义县', 130700, 1);
INSERT INTO `codeworld_area` VALUES (130726, '蔚县', 130700, 1);
INSERT INTO `codeworld_area` VALUES (130727, '阳原县', 130700, 1);
INSERT INTO `codeworld_area` VALUES (130728, '怀安县', 130700, 1);
INSERT INTO `codeworld_area` VALUES (130729, '万全县', 130700, 1);
INSERT INTO `codeworld_area` VALUES (130730, '怀来县', 130700, 1);
INSERT INTO `codeworld_area` VALUES (130731, '涿鹿县', 130700, 1);
INSERT INTO `codeworld_area` VALUES (130732, '赤城县', 130700, 1);
INSERT INTO `codeworld_area` VALUES (130733, '崇礼县', 130700, 1);
INSERT INTO `codeworld_area` VALUES (130800, '承德市', 130000, 1);
INSERT INTO `codeworld_area` VALUES (130801, '市辖区', 130800, 1);
INSERT INTO `codeworld_area` VALUES (130802, '双桥区', 130801, 1);
INSERT INTO `codeworld_area` VALUES (130803, '双滦区', 130801, 1);
INSERT INTO `codeworld_area` VALUES (130804, '鹰手营子矿区', 130801, 1);
INSERT INTO `codeworld_area` VALUES (130821, '承德县', 130800, 1);
INSERT INTO `codeworld_area` VALUES (130822, '兴隆县', 130800, 1);
INSERT INTO `codeworld_area` VALUES (130823, '平泉县', 130800, 1);
INSERT INTO `codeworld_area` VALUES (130824, '滦平县', 130800, 1);
INSERT INTO `codeworld_area` VALUES (130825, '隆化县', 130800, 1);
INSERT INTO `codeworld_area` VALUES (130826, '丰宁满族自治县', 130800, 1);
INSERT INTO `codeworld_area` VALUES (130827, '宽城满族自治县', 130800, 1);
INSERT INTO `codeworld_area` VALUES (130828, '围场满族蒙古族自治县', 130800, 1);
INSERT INTO `codeworld_area` VALUES (130900, '沧州市', 130000, 1);
INSERT INTO `codeworld_area` VALUES (130901, '市辖区', 130900, 1);
INSERT INTO `codeworld_area` VALUES (130902, '新华区', 130901, 1);
INSERT INTO `codeworld_area` VALUES (130903, '运河区', 130901, 1);
INSERT INTO `codeworld_area` VALUES (130921, '沧县', 130900, 1);
INSERT INTO `codeworld_area` VALUES (130922, '青县', 130900, 1);
INSERT INTO `codeworld_area` VALUES (130923, '东光县', 130900, 1);
INSERT INTO `codeworld_area` VALUES (130924, '海兴县', 130900, 1);
INSERT INTO `codeworld_area` VALUES (130925, '盐山县', 130900, 1);
INSERT INTO `codeworld_area` VALUES (130926, '肃宁县', 130900, 1);
INSERT INTO `codeworld_area` VALUES (130927, '南皮县', 130900, 1);
INSERT INTO `codeworld_area` VALUES (130928, '吴桥县', 130900, 1);
INSERT INTO `codeworld_area` VALUES (130929, '献县', 130900, 1);
INSERT INTO `codeworld_area` VALUES (130930, '孟村回族自治县', 130900, 1);
INSERT INTO `codeworld_area` VALUES (130981, '泊头市', 130900, 1);
INSERT INTO `codeworld_area` VALUES (130982, '任丘市', 130900, 1);
INSERT INTO `codeworld_area` VALUES (130983, '黄骅市', 130900, 1);
INSERT INTO `codeworld_area` VALUES (130984, '河间市', 130900, 1);
INSERT INTO `codeworld_area` VALUES (131000, '廊坊市', 130000, 1);
INSERT INTO `codeworld_area` VALUES (131001, '市辖区', 131000, 1);
INSERT INTO `codeworld_area` VALUES (131002, '安次区', 131001, 1);
INSERT INTO `codeworld_area` VALUES (131003, '广阳区', 131001, 1);
INSERT INTO `codeworld_area` VALUES (131022, '固安县', 131000, 1);
INSERT INTO `codeworld_area` VALUES (131023, '永清县', 131000, 1);
INSERT INTO `codeworld_area` VALUES (131024, '香河县', 131000, 1);
INSERT INTO `codeworld_area` VALUES (131025, '大城县', 131000, 1);
INSERT INTO `codeworld_area` VALUES (131026, '文安县', 131000, 1);
INSERT INTO `codeworld_area` VALUES (131028, '大厂回族自治县', 131000, 1);
INSERT INTO `codeworld_area` VALUES (131081, '霸州市', 131000, 1);
INSERT INTO `codeworld_area` VALUES (131082, '三河市', 131000, 1);
INSERT INTO `codeworld_area` VALUES (131100, '衡水市', 130000, 1);
INSERT INTO `codeworld_area` VALUES (131101, '市辖区', 131100, 1);
INSERT INTO `codeworld_area` VALUES (131102, '桃城区', 131101, 1);
INSERT INTO `codeworld_area` VALUES (131121, '枣强县', 131100, 1);
INSERT INTO `codeworld_area` VALUES (131122, '武邑县', 131100, 1);
INSERT INTO `codeworld_area` VALUES (131123, '武强县', 131100, 1);
INSERT INTO `codeworld_area` VALUES (131124, '饶阳县', 131100, 1);
INSERT INTO `codeworld_area` VALUES (131125, '安平县', 131100, 1);
INSERT INTO `codeworld_area` VALUES (131126, '故城县', 131100, 1);
INSERT INTO `codeworld_area` VALUES (131127, '景县', 131100, 1);
INSERT INTO `codeworld_area` VALUES (131128, '阜城县', 131100, 1);
INSERT INTO `codeworld_area` VALUES (131181, '冀州市', 131100, 1);
INSERT INTO `codeworld_area` VALUES (131182, '深州市', 131100, 1);
INSERT INTO `codeworld_area` VALUES (140000, '山西省', 0, 1);
INSERT INTO `codeworld_area` VALUES (140100, '太原市', 140000, 1);
INSERT INTO `codeworld_area` VALUES (140101, '市辖区', 140100, 1);
INSERT INTO `codeworld_area` VALUES (140105, '小店区', 140101, 1);
INSERT INTO `codeworld_area` VALUES (140106, '迎泽区', 140101, 1);
INSERT INTO `codeworld_area` VALUES (140107, '杏花岭区', 140101, 1);
INSERT INTO `codeworld_area` VALUES (140108, '尖草坪区', 140101, 1);
INSERT INTO `codeworld_area` VALUES (140109, '万柏林区', 140101, 1);
INSERT INTO `codeworld_area` VALUES (140110, '晋源区', 140101, 1);
INSERT INTO `codeworld_area` VALUES (140121, '清徐县', 140100, 1);
INSERT INTO `codeworld_area` VALUES (140122, '阳曲县', 140100, 1);
INSERT INTO `codeworld_area` VALUES (140123, '娄烦县', 140100, 1);
INSERT INTO `codeworld_area` VALUES (140181, '古交市', 140100, 1);
INSERT INTO `codeworld_area` VALUES (140200, '大同市', 140000, 1);
INSERT INTO `codeworld_area` VALUES (140201, '市辖区', 140200, 1);
INSERT INTO `codeworld_area` VALUES (140202, '城区', 140201, 1);
INSERT INTO `codeworld_area` VALUES (140203, '矿区', 140201, 1);
INSERT INTO `codeworld_area` VALUES (140211, '南郊区', 140201, 1);
INSERT INTO `codeworld_area` VALUES (140212, '新荣区', 140201, 1);
INSERT INTO `codeworld_area` VALUES (140221, '阳高县', 140200, 1);
INSERT INTO `codeworld_area` VALUES (140222, '天镇县', 140200, 1);
INSERT INTO `codeworld_area` VALUES (140223, '广灵县', 140200, 1);
INSERT INTO `codeworld_area` VALUES (140224, '灵丘县', 140200, 1);
INSERT INTO `codeworld_area` VALUES (140225, '浑源县', 140200, 1);
INSERT INTO `codeworld_area` VALUES (140226, '左云县', 140200, 1);
INSERT INTO `codeworld_area` VALUES (140227, '大同县', 140200, 1);
INSERT INTO `codeworld_area` VALUES (140300, '阳泉市', 140000, 1);
INSERT INTO `codeworld_area` VALUES (140301, '市辖区', 140300, 1);
INSERT INTO `codeworld_area` VALUES (140302, '城区', 140301, 1);
INSERT INTO `codeworld_area` VALUES (140303, '矿区', 140301, 1);
INSERT INTO `codeworld_area` VALUES (140311, '郊区', 140301, 1);
INSERT INTO `codeworld_area` VALUES (140321, '平定县', 140300, 1);
INSERT INTO `codeworld_area` VALUES (140322, '盂县', 140300, 1);
INSERT INTO `codeworld_area` VALUES (140400, '长治市', 140000, 1);
INSERT INTO `codeworld_area` VALUES (140401, '市辖区', 140400, 1);
INSERT INTO `codeworld_area` VALUES (140402, '城区', 140401, 1);
INSERT INTO `codeworld_area` VALUES (140411, '郊区', 140401, 1);
INSERT INTO `codeworld_area` VALUES (140421, '长治县', 140400, 1);
INSERT INTO `codeworld_area` VALUES (140423, '襄垣县', 140400, 1);
INSERT INTO `codeworld_area` VALUES (140424, '屯留县', 140400, 1);
INSERT INTO `codeworld_area` VALUES (140425, '平顺县', 140400, 1);
INSERT INTO `codeworld_area` VALUES (140426, '黎城县', 140400, 1);
INSERT INTO `codeworld_area` VALUES (140427, '壶关县', 140400, 1);
INSERT INTO `codeworld_area` VALUES (140428, '长子县', 140400, 1);
INSERT INTO `codeworld_area` VALUES (140429, '武乡县', 140400, 1);
INSERT INTO `codeworld_area` VALUES (140430, '沁县', 140400, 1);
INSERT INTO `codeworld_area` VALUES (140431, '沁源县', 140400, 1);
INSERT INTO `codeworld_area` VALUES (140481, '潞城市', 140400, 1);
INSERT INTO `codeworld_area` VALUES (140500, '晋城市', 140000, 1);
INSERT INTO `codeworld_area` VALUES (140501, '市辖区', 140500, 1);
INSERT INTO `codeworld_area` VALUES (140502, '城区', 140501, 1);
INSERT INTO `codeworld_area` VALUES (140521, '沁水县', 140500, 1);
INSERT INTO `codeworld_area` VALUES (140522, '阳城县', 140500, 1);
INSERT INTO `codeworld_area` VALUES (140524, '陵川县', 140500, 1);
INSERT INTO `codeworld_area` VALUES (140525, '泽州县', 140500, 1);
INSERT INTO `codeworld_area` VALUES (140581, '高平市', 140500, 1);
INSERT INTO `codeworld_area` VALUES (140600, '朔州市', 140000, 1);
INSERT INTO `codeworld_area` VALUES (140601, '市辖区', 140600, 1);
INSERT INTO `codeworld_area` VALUES (140602, '朔城区', 140601, 1);
INSERT INTO `codeworld_area` VALUES (140603, '平鲁区', 140601, 1);
INSERT INTO `codeworld_area` VALUES (140621, '山阴县', 140600, 1);
INSERT INTO `codeworld_area` VALUES (140622, '应县', 140600, 1);
INSERT INTO `codeworld_area` VALUES (140623, '右玉县', 140600, 1);
INSERT INTO `codeworld_area` VALUES (140624, '怀仁县', 140600, 1);
INSERT INTO `codeworld_area` VALUES (140700, '晋中市', 140000, 1);
INSERT INTO `codeworld_area` VALUES (140701, '市辖区', 140700, 1);
INSERT INTO `codeworld_area` VALUES (140702, '榆次区', 140701, 1);
INSERT INTO `codeworld_area` VALUES (140721, '榆社县', 140700, 1);
INSERT INTO `codeworld_area` VALUES (140722, '左权县', 140700, 1);
INSERT INTO `codeworld_area` VALUES (140723, '和顺县', 140700, 1);
INSERT INTO `codeworld_area` VALUES (140724, '昔阳县', 140700, 1);
INSERT INTO `codeworld_area` VALUES (140725, '寿阳县', 140700, 1);
INSERT INTO `codeworld_area` VALUES (140726, '太谷县', 140700, 1);
INSERT INTO `codeworld_area` VALUES (140727, '祁县', 140700, 1);
INSERT INTO `codeworld_area` VALUES (140728, '平遥县', 140700, 1);
INSERT INTO `codeworld_area` VALUES (140729, '灵石县', 140700, 1);
INSERT INTO `codeworld_area` VALUES (140781, '介休市', 140700, 1);
INSERT INTO `codeworld_area` VALUES (140800, '运城市', 140000, 1);
INSERT INTO `codeworld_area` VALUES (140801, '市辖区', 140800, 1);
INSERT INTO `codeworld_area` VALUES (140802, '盐湖区', 140801, 1);
INSERT INTO `codeworld_area` VALUES (140821, '临猗县', 140800, 1);
INSERT INTO `codeworld_area` VALUES (140822, '万荣县', 140800, 1);
INSERT INTO `codeworld_area` VALUES (140823, '闻喜县', 140800, 1);
INSERT INTO `codeworld_area` VALUES (140824, '稷山县', 140800, 1);
INSERT INTO `codeworld_area` VALUES (140825, '新绛县', 140800, 1);
INSERT INTO `codeworld_area` VALUES (140826, '绛县', 140800, 1);
INSERT INTO `codeworld_area` VALUES (140827, '垣曲县', 140800, 1);
INSERT INTO `codeworld_area` VALUES (140828, '夏县', 140800, 1);
INSERT INTO `codeworld_area` VALUES (140829, '平陆县', 140800, 1);
INSERT INTO `codeworld_area` VALUES (140830, '芮城县', 140800, 1);
INSERT INTO `codeworld_area` VALUES (140881, '永济市', 140800, 1);
INSERT INTO `codeworld_area` VALUES (140882, '河津市', 140800, 1);
INSERT INTO `codeworld_area` VALUES (140900, '忻州市', 140000, 1);
INSERT INTO `codeworld_area` VALUES (140901, '忻府区', 140900, 1);
INSERT INTO `codeworld_area` VALUES (140921, '定襄县', 140900, 1);
INSERT INTO `codeworld_area` VALUES (140922, '五台县', 140900, 1);
INSERT INTO `codeworld_area` VALUES (140923, '代县', 140900, 1);
INSERT INTO `codeworld_area` VALUES (140924, '繁峙县', 140900, 1);
INSERT INTO `codeworld_area` VALUES (140925, '宁武县', 140900, 1);
INSERT INTO `codeworld_area` VALUES (140926, '静乐县', 140900, 1);
INSERT INTO `codeworld_area` VALUES (140927, '神池县', 140900, 1);
INSERT INTO `codeworld_area` VALUES (140928, '五寨县', 140900, 1);
INSERT INTO `codeworld_area` VALUES (140929, '岢岚县', 140900, 1);
INSERT INTO `codeworld_area` VALUES (140930, '河曲县', 140900, 1);
INSERT INTO `codeworld_area` VALUES (140931, '保德县', 140900, 1);
INSERT INTO `codeworld_area` VALUES (140932, '偏关县', 140900, 1);
INSERT INTO `codeworld_area` VALUES (140981, '原平市', 140900, 1);
INSERT INTO `codeworld_area` VALUES (141000, '临汾市', 140000, 1);
INSERT INTO `codeworld_area` VALUES (141001, '市辖区', 141000, 1);
INSERT INTO `codeworld_area` VALUES (141002, '尧都区', 141000, 1);
INSERT INTO `codeworld_area` VALUES (141021, '曲沃县', 141000, 1);
INSERT INTO `codeworld_area` VALUES (141022, '翼城县', 141000, 1);
INSERT INTO `codeworld_area` VALUES (141023, '襄汾县', 141000, 1);
INSERT INTO `codeworld_area` VALUES (141024, '洪洞县', 141000, 1);
INSERT INTO `codeworld_area` VALUES (141025, '古县', 141000, 1);
INSERT INTO `codeworld_area` VALUES (141026, '安泽县', 141000, 1);
INSERT INTO `codeworld_area` VALUES (141027, '浮山县', 141000, 1);
INSERT INTO `codeworld_area` VALUES (141028, '吉县', 141000, 1);
INSERT INTO `codeworld_area` VALUES (141029, '乡宁县', 141000, 1);
INSERT INTO `codeworld_area` VALUES (141030, '大宁县', 141000, 1);
INSERT INTO `codeworld_area` VALUES (141031, '隰县', 141000, 1);
INSERT INTO `codeworld_area` VALUES (141032, '永和县', 141000, 1);
INSERT INTO `codeworld_area` VALUES (141033, '蒲县', 141000, 1);
INSERT INTO `codeworld_area` VALUES (141034, '汾西县', 141000, 1);
INSERT INTO `codeworld_area` VALUES (141081, '侯马市', 141000, 1);
INSERT INTO `codeworld_area` VALUES (141082, '霍州市', 141000, 1);
INSERT INTO `codeworld_area` VALUES (141100, '吕梁市', 140000, 1);
INSERT INTO `codeworld_area` VALUES (141101, '市辖区', 141100, 1);
INSERT INTO `codeworld_area` VALUES (141102, '离石区', 141101, 1);
INSERT INTO `codeworld_area` VALUES (141121, '文水县', 141100, 1);
INSERT INTO `codeworld_area` VALUES (141122, '交城县', 141100, 1);
INSERT INTO `codeworld_area` VALUES (141123, '兴县', 141100, 1);
INSERT INTO `codeworld_area` VALUES (141124, '临县', 141100, 1);
INSERT INTO `codeworld_area` VALUES (141125, '柳林县', 141100, 1);
INSERT INTO `codeworld_area` VALUES (141126, '石楼县', 141100, 1);
INSERT INTO `codeworld_area` VALUES (141127, '岚县', 141100, 1);
INSERT INTO `codeworld_area` VALUES (141128, '方山县', 141100, 1);
INSERT INTO `codeworld_area` VALUES (141129, '中阳县', 141100, 1);
INSERT INTO `codeworld_area` VALUES (141130, '交口县', 141100, 1);
INSERT INTO `codeworld_area` VALUES (141181, '孝义市', 141100, 1);
INSERT INTO `codeworld_area` VALUES (141182, '汾阳市', 141100, 1);
INSERT INTO `codeworld_area` VALUES (150000, '内蒙古自治区', 0, 1);
INSERT INTO `codeworld_area` VALUES (150100, '呼和浩特市', 150000, 1);
INSERT INTO `codeworld_area` VALUES (150101, '市辖区', 150100, 1);
INSERT INTO `codeworld_area` VALUES (150102, '新城区', 150101, 1);
INSERT INTO `codeworld_area` VALUES (150103, '回民区', 150101, 1);
INSERT INTO `codeworld_area` VALUES (150104, '玉泉区', 150101, 1);
INSERT INTO `codeworld_area` VALUES (150105, '赛罕区', 150101, 1);
INSERT INTO `codeworld_area` VALUES (150121, '土默特左旗', 150100, 1);
INSERT INTO `codeworld_area` VALUES (150122, '托克托县', 150100, 1);
INSERT INTO `codeworld_area` VALUES (150123, '和林格尔县', 150100, 1);
INSERT INTO `codeworld_area` VALUES (150124, '清水河县', 150100, 1);
INSERT INTO `codeworld_area` VALUES (150125, '武川县', 150100, 1);
INSERT INTO `codeworld_area` VALUES (150200, '包头市', 150000, 1);
INSERT INTO `codeworld_area` VALUES (150201, '市辖区', 150200, 1);
INSERT INTO `codeworld_area` VALUES (150202, '东河区', 150201, 1);
INSERT INTO `codeworld_area` VALUES (150203, '昆都仑区', 150201, 1);
INSERT INTO `codeworld_area` VALUES (150204, '青山区', 150201, 1);
INSERT INTO `codeworld_area` VALUES (150205, '石拐区', 150201, 1);
INSERT INTO `codeworld_area` VALUES (150206, '白云矿区', 150201, 1);
INSERT INTO `codeworld_area` VALUES (150207, '九原区', 150201, 1);
INSERT INTO `codeworld_area` VALUES (150221, '土默特右旗', 150200, 1);
INSERT INTO `codeworld_area` VALUES (150222, '固阳县', 150200, 1);
INSERT INTO `codeworld_area` VALUES (150223, '达尔罕茂明安联合旗', 150200, 1);
INSERT INTO `codeworld_area` VALUES (150300, '乌海市', 150000, 1);
INSERT INTO `codeworld_area` VALUES (150301, '市辖区', 150300, 1);
INSERT INTO `codeworld_area` VALUES (150302, '海勃湾区', 150301, 1);
INSERT INTO `codeworld_area` VALUES (150303, '海南区', 150301, 1);
INSERT INTO `codeworld_area` VALUES (150304, '乌达区', 150301, 1);
INSERT INTO `codeworld_area` VALUES (150400, '赤峰市', 150000, 1);
INSERT INTO `codeworld_area` VALUES (150401, '市辖区', 150400, 1);
INSERT INTO `codeworld_area` VALUES (150402, '红山区', 150401, 1);
INSERT INTO `codeworld_area` VALUES (150403, '元宝山区', 150401, 1);
INSERT INTO `codeworld_area` VALUES (150404, '松山区', 150401, 1);
INSERT INTO `codeworld_area` VALUES (150421, '阿鲁科尔沁旗', 150400, 1);
INSERT INTO `codeworld_area` VALUES (150422, '巴林左旗', 150400, 1);
INSERT INTO `codeworld_area` VALUES (150423, '巴林右旗', 150400, 1);
INSERT INTO `codeworld_area` VALUES (150424, '林西县', 150400, 1);
INSERT INTO `codeworld_area` VALUES (150425, '克什克腾旗', 150400, 1);
INSERT INTO `codeworld_area` VALUES (150426, '翁牛特旗', 150400, 1);
INSERT INTO `codeworld_area` VALUES (150428, '喀喇沁旗', 150400, 1);
INSERT INTO `codeworld_area` VALUES (150429, '宁城县', 150400, 1);
INSERT INTO `codeworld_area` VALUES (150430, '敖汉旗', 150400, 1);
INSERT INTO `codeworld_area` VALUES (150500, '通辽市', 150000, 1);
INSERT INTO `codeworld_area` VALUES (150501, '市辖区', 150500, 1);
INSERT INTO `codeworld_area` VALUES (150502, '科尔沁区', 150501, 1);
INSERT INTO `codeworld_area` VALUES (150521, '科尔沁左翼中旗', 150500, 1);
INSERT INTO `codeworld_area` VALUES (150522, '科尔沁左翼后旗', 150500, 1);
INSERT INTO `codeworld_area` VALUES (150523, '开鲁县', 150500, 1);
INSERT INTO `codeworld_area` VALUES (150524, '库伦旗', 150500, 1);
INSERT INTO `codeworld_area` VALUES (150525, '奈曼旗', 150500, 1);
INSERT INTO `codeworld_area` VALUES (150526, '扎鲁特旗', 150500, 1);
INSERT INTO `codeworld_area` VALUES (150581, '霍林郭勒市', 150500, 1);
INSERT INTO `codeworld_area` VALUES (150600, '鄂尔多斯市', 150000, 1);
INSERT INTO `codeworld_area` VALUES (150602, '东胜区', 150600, 1);
INSERT INTO `codeworld_area` VALUES (150621, '达拉特旗', 150600, 1);
INSERT INTO `codeworld_area` VALUES (150622, '准格尔旗', 150600, 1);
INSERT INTO `codeworld_area` VALUES (150623, '鄂托克前旗', 150600, 1);
INSERT INTO `codeworld_area` VALUES (150624, '鄂托克旗', 150600, 1);
INSERT INTO `codeworld_area` VALUES (150625, '杭锦旗', 150600, 1);
INSERT INTO `codeworld_area` VALUES (150626, '乌审旗', 150600, 1);
INSERT INTO `codeworld_area` VALUES (150627, '伊金霍洛旗', 150600, 1);
INSERT INTO `codeworld_area` VALUES (150700, '呼伦贝尔市', 150000, 1);
INSERT INTO `codeworld_area` VALUES (150701, '市辖区', 150700, 1);
INSERT INTO `codeworld_area` VALUES (150702, '海拉尔区', 150701, 1);
INSERT INTO `codeworld_area` VALUES (150721, '阿荣旗', 150700, 1);
INSERT INTO `codeworld_area` VALUES (150722, '莫力达瓦达斡尔族自治旗', 150700, 1);
INSERT INTO `codeworld_area` VALUES (150723, '鄂伦春自治旗', 150700, 1);
INSERT INTO `codeworld_area` VALUES (150724, '鄂温克族自治旗', 150700, 1);
INSERT INTO `codeworld_area` VALUES (150725, '陈巴尔虎旗', 150700, 1);
INSERT INTO `codeworld_area` VALUES (150726, '新巴尔虎左旗', 150700, 1);
INSERT INTO `codeworld_area` VALUES (150727, '新巴尔虎右旗', 150700, 1);
INSERT INTO `codeworld_area` VALUES (150781, '满洲里市', 150700, 1);
INSERT INTO `codeworld_area` VALUES (150782, '牙克石市', 150700, 1);
INSERT INTO `codeworld_area` VALUES (150783, '扎兰屯市', 150700, 1);
INSERT INTO `codeworld_area` VALUES (150784, '额尔古纳市', 150700, 1);
INSERT INTO `codeworld_area` VALUES (150785, '根河市', 150700, 1);
INSERT INTO `codeworld_area` VALUES (150800, '巴彦淖尔市', 150000, 1);
INSERT INTO `codeworld_area` VALUES (150801, '市辖区', 150800, 1);
INSERT INTO `codeworld_area` VALUES (150802, '临河区', 150800, 1);
INSERT INTO `codeworld_area` VALUES (150821, '五原县', 150800, 1);
INSERT INTO `codeworld_area` VALUES (150822, '磴口县', 150800, 1);
INSERT INTO `codeworld_area` VALUES (150823, '乌拉特前旗', 150800, 1);
INSERT INTO `codeworld_area` VALUES (150824, '乌拉特中旗', 150800, 1);
INSERT INTO `codeworld_area` VALUES (150825, '乌拉特后旗', 150800, 1);
INSERT INTO `codeworld_area` VALUES (150826, '杭锦后旗', 150800, 1);
INSERT INTO `codeworld_area` VALUES (150900, '乌兰察布市', 150000, 1);
INSERT INTO `codeworld_area` VALUES (150901, '市辖区', 150900, 1);
INSERT INTO `codeworld_area` VALUES (150902, '集宁区', 150901, 1);
INSERT INTO `codeworld_area` VALUES (150921, '卓资县', 150900, 1);
INSERT INTO `codeworld_area` VALUES (150922, '化德县', 150900, 1);
INSERT INTO `codeworld_area` VALUES (150923, '商都县', 150900, 1);
INSERT INTO `codeworld_area` VALUES (150924, '兴和县', 150900, 1);
INSERT INTO `codeworld_area` VALUES (150925, '凉城县', 150900, 1);
INSERT INTO `codeworld_area` VALUES (150926, '察哈尔右翼前旗', 150900, 1);
INSERT INTO `codeworld_area` VALUES (150927, '察哈尔右翼中旗', 150900, 1);
INSERT INTO `codeworld_area` VALUES (150928, '察哈尔右翼后旗', 150900, 1);
INSERT INTO `codeworld_area` VALUES (150929, '四子王旗', 150900, 1);
INSERT INTO `codeworld_area` VALUES (150981, '丰镇市', 150900, 1);
INSERT INTO `codeworld_area` VALUES (152200, '兴安盟', 150000, 1);
INSERT INTO `codeworld_area` VALUES (152201, '乌兰浩特市', 152200, 1);
INSERT INTO `codeworld_area` VALUES (152202, '阿尔山市', 152200, 1);
INSERT INTO `codeworld_area` VALUES (152221, '科尔沁右翼前旗', 152200, 1);
INSERT INTO `codeworld_area` VALUES (152222, '科尔沁右翼中旗', 152200, 1);
INSERT INTO `codeworld_area` VALUES (152223, '扎赉特旗', 152200, 1);
INSERT INTO `codeworld_area` VALUES (152224, '突泉县', 152200, 1);
INSERT INTO `codeworld_area` VALUES (152500, '锡林郭勒盟', 150000, 1);
INSERT INTO `codeworld_area` VALUES (152501, '二连浩特市', 152500, 1);
INSERT INTO `codeworld_area` VALUES (152502, '锡林浩特市', 152500, 1);
INSERT INTO `codeworld_area` VALUES (152522, '阿巴嘎旗', 152500, 1);
INSERT INTO `codeworld_area` VALUES (152523, '苏尼特左旗', 152500, 1);
INSERT INTO `codeworld_area` VALUES (152524, '苏尼特右旗', 152500, 1);
INSERT INTO `codeworld_area` VALUES (152525, '东乌珠穆沁旗', 152500, 1);
INSERT INTO `codeworld_area` VALUES (152526, '西乌珠穆沁旗', 152500, 1);
INSERT INTO `codeworld_area` VALUES (152527, '太仆寺旗', 152500, 1);
INSERT INTO `codeworld_area` VALUES (152528, '镶黄旗', 152500, 1);
INSERT INTO `codeworld_area` VALUES (152529, '正镶白旗', 152500, 1);
INSERT INTO `codeworld_area` VALUES (152530, '正蓝旗', 152500, 1);
INSERT INTO `codeworld_area` VALUES (152531, '多伦县', 152500, 1);
INSERT INTO `codeworld_area` VALUES (152900, '阿拉善盟', 150000, 1);
INSERT INTO `codeworld_area` VALUES (152921, '阿拉善左旗', 152900, 1);
INSERT INTO `codeworld_area` VALUES (152922, '阿拉善右旗', 152900, 1);
INSERT INTO `codeworld_area` VALUES (152923, '额济纳旗', 152900, 1);
INSERT INTO `codeworld_area` VALUES (210000, '辽宁省', 0, 1);
INSERT INTO `codeworld_area` VALUES (210100, '沈阳市', 210000, 1);
INSERT INTO `codeworld_area` VALUES (210101, '市辖区', 210100, 1);
INSERT INTO `codeworld_area` VALUES (210102, '和平区', 210101, 1);
INSERT INTO `codeworld_area` VALUES (210103, '沈河区', 210101, 1);
INSERT INTO `codeworld_area` VALUES (210104, '大东区', 210101, 1);
INSERT INTO `codeworld_area` VALUES (210105, '皇姑区', 210101, 1);
INSERT INTO `codeworld_area` VALUES (210106, '铁西区', 210101, 1);
INSERT INTO `codeworld_area` VALUES (210111, '苏家屯区', 210101, 1);
INSERT INTO `codeworld_area` VALUES (210112, '东陵区', 210101, 1);
INSERT INTO `codeworld_area` VALUES (210113, '新城子区', 210101, 1);
INSERT INTO `codeworld_area` VALUES (210114, '于洪区', 210101, 1);
INSERT INTO `codeworld_area` VALUES (210122, '辽中县', 210100, 1);
INSERT INTO `codeworld_area` VALUES (210123, '康平县', 210100, 1);
INSERT INTO `codeworld_area` VALUES (210124, '法库县', 210100, 1);
INSERT INTO `codeworld_area` VALUES (210181, '新民市', 210100, 1);
INSERT INTO `codeworld_area` VALUES (210182, '沈北新区', 210100, 1);
INSERT INTO `codeworld_area` VALUES (210200, '大连市', 210000, 1);
INSERT INTO `codeworld_area` VALUES (210201, '市辖区', 210200, 1);
INSERT INTO `codeworld_area` VALUES (210202, '中山区', 210201, 1);
INSERT INTO `codeworld_area` VALUES (210203, '西岗区', 210201, 1);
INSERT INTO `codeworld_area` VALUES (210204, '沙河口区', 210201, 1);
INSERT INTO `codeworld_area` VALUES (210211, '甘井子区', 210201, 1);
INSERT INTO `codeworld_area` VALUES (210212, '旅顺口区', 210201, 1);
INSERT INTO `codeworld_area` VALUES (210213, '金州区', 210201, 1);
INSERT INTO `codeworld_area` VALUES (210224, '长海县', 210200, 1);
INSERT INTO `codeworld_area` VALUES (210281, '瓦房店市', 210200, 1);
INSERT INTO `codeworld_area` VALUES (210282, '普兰店市', 210200, 1);
INSERT INTO `codeworld_area` VALUES (210283, '庄河市', 210200, 1);
INSERT INTO `codeworld_area` VALUES (210300, '鞍山市', 210000, 1);
INSERT INTO `codeworld_area` VALUES (210301, '市辖区', 210300, 1);
INSERT INTO `codeworld_area` VALUES (210302, '铁东区', 210301, 1);
INSERT INTO `codeworld_area` VALUES (210303, '铁西区', 210301, 1);
INSERT INTO `codeworld_area` VALUES (210304, '立山区', 210301, 1);
INSERT INTO `codeworld_area` VALUES (210311, '千山区', 210301, 1);
INSERT INTO `codeworld_area` VALUES (210321, '台安县', 210300, 1);
INSERT INTO `codeworld_area` VALUES (210323, '岫岩满族自治县', 210300, 1);
INSERT INTO `codeworld_area` VALUES (210381, '海城市', 210300, 1);
INSERT INTO `codeworld_area` VALUES (210400, '抚顺市', 210000, 1);
INSERT INTO `codeworld_area` VALUES (210401, '市辖区', 210400, 1);
INSERT INTO `codeworld_area` VALUES (210402, '新抚区', 210401, 1);
INSERT INTO `codeworld_area` VALUES (210403, '东洲区', 210401, 1);
INSERT INTO `codeworld_area` VALUES (210404, '望花区', 210401, 1);
INSERT INTO `codeworld_area` VALUES (210411, '顺城区', 210401, 1);
INSERT INTO `codeworld_area` VALUES (210421, '抚顺县', 210400, 1);
INSERT INTO `codeworld_area` VALUES (210422, '新宾满族自治县', 210400, 1);
INSERT INTO `codeworld_area` VALUES (210423, '清原满族自治县', 210400, 1);
INSERT INTO `codeworld_area` VALUES (210500, '本溪市', 210000, 1);
INSERT INTO `codeworld_area` VALUES (210501, '市辖区', 210500, 1);
INSERT INTO `codeworld_area` VALUES (210502, '平山区', 210501, 1);
INSERT INTO `codeworld_area` VALUES (210503, '溪湖??', 210501, 1);
INSERT INTO `codeworld_area` VALUES (210504, '明山区', 210501, 1);
INSERT INTO `codeworld_area` VALUES (210505, '南芬区', 210501, 1);
INSERT INTO `codeworld_area` VALUES (210521, '本溪满族自治县', 210500, 1);
INSERT INTO `codeworld_area` VALUES (210522, '桓仁满族自治县', 210500, 1);
INSERT INTO `codeworld_area` VALUES (210600, '丹东市', 210000, 1);
INSERT INTO `codeworld_area` VALUES (210601, '市辖区', 210600, 1);
INSERT INTO `codeworld_area` VALUES (210602, '元宝区', 210601, 1);
INSERT INTO `codeworld_area` VALUES (210603, '振兴区', 210601, 1);
INSERT INTO `codeworld_area` VALUES (210604, '振安区', 210601, 1);
INSERT INTO `codeworld_area` VALUES (210624, '宽甸满族自治县', 210600, 1);
INSERT INTO `codeworld_area` VALUES (210681, '东港市', 210600, 1);
INSERT INTO `codeworld_area` VALUES (210682, '凤城市', 210600, 1);
INSERT INTO `codeworld_area` VALUES (210700, '锦州市', 210000, 1);
INSERT INTO `codeworld_area` VALUES (210701, '市辖区', 210700, 1);
INSERT INTO `codeworld_area` VALUES (210702, '古塔区', 210701, 1);
INSERT INTO `codeworld_area` VALUES (210703, '凌河区', 210701, 1);
INSERT INTO `codeworld_area` VALUES (210711, '太和区', 210701, 1);
INSERT INTO `codeworld_area` VALUES (210726, '黑山县', 210700, 1);
INSERT INTO `codeworld_area` VALUES (210727, '义县', 210700, 1);
INSERT INTO `codeworld_area` VALUES (210781, '凌海市', 210700, 1);
INSERT INTO `codeworld_area` VALUES (210782, '北宁市', 210700, 1);
INSERT INTO `codeworld_area` VALUES (210800, '营口市', 210000, 1);
INSERT INTO `codeworld_area` VALUES (210801, '市辖区', 210800, 1);
INSERT INTO `codeworld_area` VALUES (210802, '站前区', 210801, 1);
INSERT INTO `codeworld_area` VALUES (210803, '西市区', 210801, 1);
INSERT INTO `codeworld_area` VALUES (210804, '鲅鱼圈区', 210801, 1);
INSERT INTO `codeworld_area` VALUES (210811, '老边区', 210801, 1);
INSERT INTO `codeworld_area` VALUES (210881, '盖州市', 210800, 1);
INSERT INTO `codeworld_area` VALUES (210882, '大石桥市', 210800, 1);
INSERT INTO `codeworld_area` VALUES (210900, '阜新市', 210000, 1);
INSERT INTO `codeworld_area` VALUES (210901, '市辖区', 210900, 1);
INSERT INTO `codeworld_area` VALUES (210902, '海州区', 210901, 1);
INSERT INTO `codeworld_area` VALUES (210903, '新邱区', 210901, 1);
INSERT INTO `codeworld_area` VALUES (210904, '太平区', 210901, 1);
INSERT INTO `codeworld_area` VALUES (210905, '清河门区', 210901, 1);
INSERT INTO `codeworld_area` VALUES (210911, '细河区', 210901, 1);
INSERT INTO `codeworld_area` VALUES (210921, '阜新蒙古族自治县', 210900, 1);
INSERT INTO `codeworld_area` VALUES (210922, '彰武县', 210900, 1);
INSERT INTO `codeworld_area` VALUES (211000, '辽阳市', 210000, 1);
INSERT INTO `codeworld_area` VALUES (211001, '市辖区', 211000, 1);
INSERT INTO `codeworld_area` VALUES (211002, '白塔区', 211001, 1);
INSERT INTO `codeworld_area` VALUES (211003, '文圣区', 211001, 1);
INSERT INTO `codeworld_area` VALUES (211004, '宏伟区', 211001, 1);
INSERT INTO `codeworld_area` VALUES (211005, '弓长岭区', 211001, 1);
INSERT INTO `codeworld_area` VALUES (211011, '太子河区', 211001, 1);
INSERT INTO `codeworld_area` VALUES (211021, '辽阳县', 211000, 1);
INSERT INTO `codeworld_area` VALUES (211081, '灯塔市', 211000, 1);
INSERT INTO `codeworld_area` VALUES (211100, '盘锦市', 210000, 1);
INSERT INTO `codeworld_area` VALUES (211101, '市辖区', 211100, 1);
INSERT INTO `codeworld_area` VALUES (211102, '双台子区', 211101, 1);
INSERT INTO `codeworld_area` VALUES (211103, '兴隆台区', 211101, 1);
INSERT INTO `codeworld_area` VALUES (211121, '大洼县', 211100, 1);
INSERT INTO `codeworld_area` VALUES (211122, '盘山县', 211100, 1);
INSERT INTO `codeworld_area` VALUES (211200, '铁岭市', 210000, 1);
INSERT INTO `codeworld_area` VALUES (211201, '市辖区', 211200, 1);
INSERT INTO `codeworld_area` VALUES (211202, '银州区', 211201, 1);
INSERT INTO `codeworld_area` VALUES (211204, '清河区', 211201, 1);
INSERT INTO `codeworld_area` VALUES (211221, '铁岭县', 211200, 1);
INSERT INTO `codeworld_area` VALUES (211223, '西丰县', 211200, 1);
INSERT INTO `codeworld_area` VALUES (211224, '昌图县', 211200, 1);
INSERT INTO `codeworld_area` VALUES (211281, '调兵山市', 211200, 1);
INSERT INTO `codeworld_area` VALUES (211282, '开原市', 211200, 1);
INSERT INTO `codeworld_area` VALUES (211300, '朝阳市', 210000, 1);
INSERT INTO `codeworld_area` VALUES (211301, '市辖区', 211300, 1);
INSERT INTO `codeworld_area` VALUES (211302, '双塔区', 211301, 1);
INSERT INTO `codeworld_area` VALUES (211303, '龙城区', 211301, 1);
INSERT INTO `codeworld_area` VALUES (211321, '朝阳县', 211300, 1);
INSERT INTO `codeworld_area` VALUES (211322, '建平县', 211300, 1);
INSERT INTO `codeworld_area` VALUES (211324, '喀喇沁左翼蒙古族自治县', 211300, 1);
INSERT INTO `codeworld_area` VALUES (211381, '北票市', 211300, 1);
INSERT INTO `codeworld_area` VALUES (211382, '凌源市', 211300, 1);
INSERT INTO `codeworld_area` VALUES (211400, '葫芦岛市', 210000, 1);
INSERT INTO `codeworld_area` VALUES (211401, '市辖区', 211400, 1);
INSERT INTO `codeworld_area` VALUES (211402, '连山区', 211401, 1);
INSERT INTO `codeworld_area` VALUES (211403, '龙港区', 211401, 1);
INSERT INTO `codeworld_area` VALUES (211404, '南票区', 211401, 1);
INSERT INTO `codeworld_area` VALUES (211421, '绥中县', 211400, 1);
INSERT INTO `codeworld_area` VALUES (211422, '建昌县', 211400, 1);
INSERT INTO `codeworld_area` VALUES (211481, '兴城市', 211400, 1);
INSERT INTO `codeworld_area` VALUES (220000, '吉林省', 0, 1);
INSERT INTO `codeworld_area` VALUES (220100, '长春市', 220000, 1);
INSERT INTO `codeworld_area` VALUES (220101, '市辖区', 220100, 1);
INSERT INTO `codeworld_area` VALUES (220102, '南关区', 220101, 1);
INSERT INTO `codeworld_area` VALUES (220103, '宽城区', 220101, 1);
INSERT INTO `codeworld_area` VALUES (220104, '朝阳区', 220101, 1);
INSERT INTO `codeworld_area` VALUES (220105, '二道区', 220101, 1);
INSERT INTO `codeworld_area` VALUES (220106, '绿园区', 220101, 1);
INSERT INTO `codeworld_area` VALUES (220112, '双阳区', 220101, 1);
INSERT INTO `codeworld_area` VALUES (220122, '农安县', 220100, 1);
INSERT INTO `codeworld_area` VALUES (220181, '九台市', 220100, 1);
INSERT INTO `codeworld_area` VALUES (220182, '榆树市', 220100, 1);
INSERT INTO `codeworld_area` VALUES (220183, '德惠市', 220100, 1);
INSERT INTO `codeworld_area` VALUES (220200, '吉林市', 220000, 1);
INSERT INTO `codeworld_area` VALUES (220201, '市辖区', 220200, 1);
INSERT INTO `codeworld_area` VALUES (220202, '昌邑区', 220201, 1);
INSERT INTO `codeworld_area` VALUES (220203, '龙潭区', 220201, 1);
INSERT INTO `codeworld_area` VALUES (220204, '船营区', 220201, 1);
INSERT INTO `codeworld_area` VALUES (220211, '丰满区', 220201, 1);
INSERT INTO `codeworld_area` VALUES (220221, '永吉县', 220200, 1);
INSERT INTO `codeworld_area` VALUES (220281, '蛟河市', 220200, 1);
INSERT INTO `codeworld_area` VALUES (220282, '桦甸市', 220200, 1);
INSERT INTO `codeworld_area` VALUES (220283, '舒兰市', 220200, 1);
INSERT INTO `codeworld_area` VALUES (220284, '磐石市', 220200, 1);
INSERT INTO `codeworld_area` VALUES (220300, '四平市', 220000, 1);
INSERT INTO `codeworld_area` VALUES (220301, '市辖区', 220300, 1);
INSERT INTO `codeworld_area` VALUES (220302, '铁西区', 220301, 1);
INSERT INTO `codeworld_area` VALUES (220303, '铁东区', 220301, 1);
INSERT INTO `codeworld_area` VALUES (220322, '梨树县', 220300, 1);
INSERT INTO `codeworld_area` VALUES (220323, '伊通满族自治县', 220300, 1);
INSERT INTO `codeworld_area` VALUES (220381, '公主岭市', 220300, 1);
INSERT INTO `codeworld_area` VALUES (220382, '双辽市', 220300, 1);
INSERT INTO `codeworld_area` VALUES (220400, '辽源市', 220000, 1);
INSERT INTO `codeworld_area` VALUES (220401, '市辖区', 220400, 1);
INSERT INTO `codeworld_area` VALUES (220402, '龙山区', 220401, 1);
INSERT INTO `codeworld_area` VALUES (220403, '西安区', 220401, 1);
INSERT INTO `codeworld_area` VALUES (220421, '东丰县', 220400, 1);
INSERT INTO `codeworld_area` VALUES (220422, '东辽县', 220400, 1);
INSERT INTO `codeworld_area` VALUES (220500, '通化市', 220000, 1);
INSERT INTO `codeworld_area` VALUES (220501, '市辖区', 220500, 1);
INSERT INTO `codeworld_area` VALUES (220502, '东昌区', 220501, 1);
INSERT INTO `codeworld_area` VALUES (220503, '二道江区', 220501, 1);
INSERT INTO `codeworld_area` VALUES (220521, '通化县', 220500, 1);
INSERT INTO `codeworld_area` VALUES (220523, '辉南县', 220500, 1);
INSERT INTO `codeworld_area` VALUES (220524, '柳河县', 220500, 1);
INSERT INTO `codeworld_area` VALUES (220581, '梅河口市', 220500, 1);
INSERT INTO `codeworld_area` VALUES (220582, '集安市', 220500, 1);
INSERT INTO `codeworld_area` VALUES (220600, '白山市', 220000, 1);
INSERT INTO `codeworld_area` VALUES (220601, '市辖区', 220600, 1);
INSERT INTO `codeworld_area` VALUES (220602, '八道江区', 220601, 1);
INSERT INTO `codeworld_area` VALUES (220621, '抚松县', 220600, 1);
INSERT INTO `codeworld_area` VALUES (220622, '靖宇县', 220600, 1);
INSERT INTO `codeworld_area` VALUES (220623, '长白朝鲜族自治县', 220600, 1);
INSERT INTO `codeworld_area` VALUES (220625, '江源区', 220600, 1);
INSERT INTO `codeworld_area` VALUES (220681, '临江市', 220600, 1);
INSERT INTO `codeworld_area` VALUES (220700, '松原市', 220000, 1);
INSERT INTO `codeworld_area` VALUES (220701, '市辖区', 220700, 1);
INSERT INTO `codeworld_area` VALUES (220702, '宁江区', 220701, 1);
INSERT INTO `codeworld_area` VALUES (220721, '前郭尔罗斯蒙古族自治县', 220700, 1);
INSERT INTO `codeworld_area` VALUES (220722, '长岭县', 220700, 1);
INSERT INTO `codeworld_area` VALUES (220723, '乾安县', 220700, 1);
INSERT INTO `codeworld_area` VALUES (220724, '扶余市', 220700, 1);
INSERT INTO `codeworld_area` VALUES (220800, '白城市', 220000, 1);
INSERT INTO `codeworld_area` VALUES (220801, '市辖区', 220800, 1);
INSERT INTO `codeworld_area` VALUES (220802, '洮北区', 220800, 1);
INSERT INTO `codeworld_area` VALUES (220821, '镇赉县', 220800, 1);
INSERT INTO `codeworld_area` VALUES (220822, '通榆县', 220800, 1);
INSERT INTO `codeworld_area` VALUES (220881, '洮南市', 220800, 1);
INSERT INTO `codeworld_area` VALUES (220882, '大安市', 220800, 1);
INSERT INTO `codeworld_area` VALUES (222400, '延边朝鲜族自治州', 220000, 1);
INSERT INTO `codeworld_area` VALUES (222401, '延吉市', 222400, 1);
INSERT INTO `codeworld_area` VALUES (222402, '图们市', 222400, 1);
INSERT INTO `codeworld_area` VALUES (222403, '敦化市', 222400, 1);
INSERT INTO `codeworld_area` VALUES (222404, '珲春市', 222400, 1);
INSERT INTO `codeworld_area` VALUES (222405, '龙井市', 222400, 1);
INSERT INTO `codeworld_area` VALUES (222406, '和龙市', 222400, 1);
INSERT INTO `codeworld_area` VALUES (222424, '汪清县', 222400, 1);
INSERT INTO `codeworld_area` VALUES (222426, '安图县', 222400, 1);
INSERT INTO `codeworld_area` VALUES (230000, '黑龙江省', 0, 1);
INSERT INTO `codeworld_area` VALUES (230100, '哈尔滨市', 230000, 1);
INSERT INTO `codeworld_area` VALUES (230101, '市辖区', 230100, 1);
INSERT INTO `codeworld_area` VALUES (230102, '道里区', 230101, 1);
INSERT INTO `codeworld_area` VALUES (230103, '南岗区', 230101, 1);
INSERT INTO `codeworld_area` VALUES (230104, '道外区', 230101, 1);
INSERT INTO `codeworld_area` VALUES (230106, '香坊区', 230101, 1);
INSERT INTO `codeworld_area` VALUES (230107, '动力区', 230101, 1);
INSERT INTO `codeworld_area` VALUES (230108, '平房区', 230101, 1);
INSERT INTO `codeworld_area` VALUES (230109, '松北区', 230101, 1);
INSERT INTO `codeworld_area` VALUES (230111, '呼兰区', 230101, 1);
INSERT INTO `codeworld_area` VALUES (230123, '依兰县', 230100, 1);
INSERT INTO `codeworld_area` VALUES (230124, '方正县', 230100, 1);
INSERT INTO `codeworld_area` VALUES (230125, '宾县', 230100, 1);
INSERT INTO `codeworld_area` VALUES (230126, '巴彦县', 230100, 1);
INSERT INTO `codeworld_area` VALUES (230127, '木兰县', 230100, 1);
INSERT INTO `codeworld_area` VALUES (230128, '通河县', 230100, 1);
INSERT INTO `codeworld_area` VALUES (230129, '延寿县', 230100, 1);
INSERT INTO `codeworld_area` VALUES (230181, '阿城市', 230100, 1);
INSERT INTO `codeworld_area` VALUES (230182, '双城市', 230100, 1);
INSERT INTO `codeworld_area` VALUES (230183, '尚志市', 230100, 1);
INSERT INTO `codeworld_area` VALUES (230184, '五常市', 230100, 1);
INSERT INTO `codeworld_area` VALUES (230200, '齐齐哈尔市', 230000, 1);
INSERT INTO `codeworld_area` VALUES (230201, '市辖区', 230200, 1);
INSERT INTO `codeworld_area` VALUES (230202, '龙沙区', 230201, 1);
INSERT INTO `codeworld_area` VALUES (230203, '建华区', 230201, 1);
INSERT INTO `codeworld_area` VALUES (230204, '铁锋区', 230201, 1);
INSERT INTO `codeworld_area` VALUES (230205, '昂昂溪区', 230201, 1);
INSERT INTO `codeworld_area` VALUES (230206, '富拉尔基区', 230201, 1);
INSERT INTO `codeworld_area` VALUES (230207, '碾子山区', 230201, 1);
INSERT INTO `codeworld_area` VALUES (230208, '梅里斯达斡尔族区', 230201, 1);
INSERT INTO `codeworld_area` VALUES (230221, '龙江县', 230200, 1);
INSERT INTO `codeworld_area` VALUES (230223, '依安县', 230200, 1);
INSERT INTO `codeworld_area` VALUES (230224, '泰来县', 230200, 1);
INSERT INTO `codeworld_area` VALUES (230225, '甘南县', 230200, 1);
INSERT INTO `codeworld_area` VALUES (230227, '富裕县', 230200, 1);
INSERT INTO `codeworld_area` VALUES (230229, '克山县', 230200, 1);
INSERT INTO `codeworld_area` VALUES (230230, '克东县', 230200, 1);
INSERT INTO `codeworld_area` VALUES (230231, '拜泉县', 230200, 1);
INSERT INTO `codeworld_area` VALUES (230281, '讷河市', 230200, 1);
INSERT INTO `codeworld_area` VALUES (230300, '鸡西市', 230000, 1);
INSERT INTO `codeworld_area` VALUES (230301, '市辖区', 230300, 1);
INSERT INTO `codeworld_area` VALUES (230302, '鸡冠区', 230301, 1);
INSERT INTO `codeworld_area` VALUES (230303, '恒山区', 230301, 1);
INSERT INTO `codeworld_area` VALUES (230304, '滴道区', 230301, 1);
INSERT INTO `codeworld_area` VALUES (230305, '梨树区', 230301, 1);
INSERT INTO `codeworld_area` VALUES (230306, '城子河区', 230301, 1);
INSERT INTO `codeworld_area` VALUES (230307, '麻山区', 230301, 1);
INSERT INTO `codeworld_area` VALUES (230321, '鸡东县', 230300, 1);
INSERT INTO `codeworld_area` VALUES (230381, '虎林市', 230300, 1);
INSERT INTO `codeworld_area` VALUES (230382, '密山市', 230300, 1);
INSERT INTO `codeworld_area` VALUES (230400, '鹤岗市', 230000, 1);
INSERT INTO `codeworld_area` VALUES (230401, '市辖区', 230400, 1);
INSERT INTO `codeworld_area` VALUES (230402, '向阳区', 230401, 1);
INSERT INTO `codeworld_area` VALUES (230403, '工农区', 230401, 1);
INSERT INTO `codeworld_area` VALUES (230404, '南山区', 230401, 1);
INSERT INTO `codeworld_area` VALUES (230405, '兴安区', 230401, 1);
INSERT INTO `codeworld_area` VALUES (230406, '东山区', 230401, 1);
INSERT INTO `codeworld_area` VALUES (230407, '兴山区', 230401, 1);
INSERT INTO `codeworld_area` VALUES (230421, '萝北县', 230400, 1);
INSERT INTO `codeworld_area` VALUES (230422, '绥滨县', 230400, 1);
INSERT INTO `codeworld_area` VALUES (230500, '双鸭山市', 230000, 1);
INSERT INTO `codeworld_area` VALUES (230501, '市辖区', 230500, 1);
INSERT INTO `codeworld_area` VALUES (230502, '尖山区', 230501, 1);
INSERT INTO `codeworld_area` VALUES (230503, '岭东区', 230501, 1);
INSERT INTO `codeworld_area` VALUES (230505, '四方台区', 230501, 1);
INSERT INTO `codeworld_area` VALUES (230506, '宝山区', 230501, 1);
INSERT INTO `codeworld_area` VALUES (230521, '集贤县', 230500, 1);
INSERT INTO `codeworld_area` VALUES (230522, '友谊县', 230500, 1);
INSERT INTO `codeworld_area` VALUES (230523, '宝清县', 230500, 1);
INSERT INTO `codeworld_area` VALUES (230524, '饶河县', 230500, 1);
INSERT INTO `codeworld_area` VALUES (230600, '大庆市', 230000, 1);
INSERT INTO `codeworld_area` VALUES (230601, '市辖区', 230600, 1);
INSERT INTO `codeworld_area` VALUES (230602, '萨尔图区', 230601, 1);
INSERT INTO `codeworld_area` VALUES (230603, '龙凤区', 230601, 1);
INSERT INTO `codeworld_area` VALUES (230604, '让胡路区', 230601, 1);
INSERT INTO `codeworld_area` VALUES (230605, '红岗区', 230601, 1);
INSERT INTO `codeworld_area` VALUES (230606, '大同区', 230601, 1);
INSERT INTO `codeworld_area` VALUES (230621, '肇州县', 230600, 1);
INSERT INTO `codeworld_area` VALUES (230622, '肇源县', 230600, 1);
INSERT INTO `codeworld_area` VALUES (230623, '林甸县', 230600, 1);
INSERT INTO `codeworld_area` VALUES (230624, '杜尔伯特蒙古族自治县', 230600, 1);
INSERT INTO `codeworld_area` VALUES (230700, '伊春市', 230000, 1);
INSERT INTO `codeworld_area` VALUES (230701, '市辖区', 230700, 1);
INSERT INTO `codeworld_area` VALUES (230702, '伊春区', 230701, 1);
INSERT INTO `codeworld_area` VALUES (230703, '南岔区', 230701, 1);
INSERT INTO `codeworld_area` VALUES (230704, '友好区', 230701, 1);
INSERT INTO `codeworld_area` VALUES (230705, '西林区', 230701, 1);
INSERT INTO `codeworld_area` VALUES (230706, '翠峦区', 230701, 1);
INSERT INTO `codeworld_area` VALUES (230707, '新青区', 230701, 1);
INSERT INTO `codeworld_area` VALUES (230708, '美溪区', 230701, 1);
INSERT INTO `codeworld_area` VALUES (230709, '金山屯区', 230701, 1);
INSERT INTO `codeworld_area` VALUES (230710, '五营区', 230701, 1);
INSERT INTO `codeworld_area` VALUES (230711, '乌马河区', 230701, 1);
INSERT INTO `codeworld_area` VALUES (230712, '汤旺河区', 230701, 1);
INSERT INTO `codeworld_area` VALUES (230713, '带岭区', 230701, 1);
INSERT INTO `codeworld_area` VALUES (230714, '乌伊岭区', 230701, 1);
INSERT INTO `codeworld_area` VALUES (230715, '红星区', 230701, 1);
INSERT INTO `codeworld_area` VALUES (230716, '上甘岭区', 230701, 1);
INSERT INTO `codeworld_area` VALUES (230722, '嘉荫县', 230700, 1);
INSERT INTO `codeworld_area` VALUES (230781, '铁力市', 230700, 1);
INSERT INTO `codeworld_area` VALUES (230800, '佳木斯市', 230000, 1);
INSERT INTO `codeworld_area` VALUES (230801, '市辖区', 230800, 1);
INSERT INTO `codeworld_area` VALUES (230803, '向阳区', 230801, 1);
INSERT INTO `codeworld_area` VALUES (230804, '前进区', 230801, 1);
INSERT INTO `codeworld_area` VALUES (230805, '东风区', 230801, 1);
INSERT INTO `codeworld_area` VALUES (230811, '郊区', 230801, 1);
INSERT INTO `codeworld_area` VALUES (230822, '桦南县', 230800, 1);
INSERT INTO `codeworld_area` VALUES (230826, '桦川县', 230800, 1);
INSERT INTO `codeworld_area` VALUES (230828, '汤原县', 230800, 1);
INSERT INTO `codeworld_area` VALUES (230833, '抚远县', 230800, 1);
INSERT INTO `codeworld_area` VALUES (230881, '同江市', 230800, 1);
INSERT INTO `codeworld_area` VALUES (230882, '富锦市', 230800, 1);
INSERT INTO `codeworld_area` VALUES (230900, '七台河市', 230000, 1);
INSERT INTO `codeworld_area` VALUES (230901, '市辖区', 230900, 1);
INSERT INTO `codeworld_area` VALUES (230902, '新兴区', 230901, 1);
INSERT INTO `codeworld_area` VALUES (230903, '桃山区', 230901, 1);
INSERT INTO `codeworld_area` VALUES (230904, '茄子河区', 230901, 1);
INSERT INTO `codeworld_area` VALUES (230921, '勃利县', 230900, 1);
INSERT INTO `codeworld_area` VALUES (231000, '牡丹江市', 230000, 1);
INSERT INTO `codeworld_area` VALUES (231001, '市辖区', 231000, 1);
INSERT INTO `codeworld_area` VALUES (231002, '东安区', 231001, 1);
INSERT INTO `codeworld_area` VALUES (231003, '阳明区', 231001, 1);
INSERT INTO `codeworld_area` VALUES (231004, '爱民区', 231001, 1);
INSERT INTO `codeworld_area` VALUES (231005, '西安区', 231001, 1);
INSERT INTO `codeworld_area` VALUES (231024, '东宁县', 231000, 1);
INSERT INTO `codeworld_area` VALUES (231025, '林口县', 231000, 1);
INSERT INTO `codeworld_area` VALUES (231081, '绥芬河市', 231000, 1);
INSERT INTO `codeworld_area` VALUES (231083, '海林市', 231000, 1);
INSERT INTO `codeworld_area` VALUES (231084, '宁安市', 231000, 1);
INSERT INTO `codeworld_area` VALUES (231085, '穆棱市', 231000, 1);
INSERT INTO `codeworld_area` VALUES (231100, '黑河市', 230000, 1);
INSERT INTO `codeworld_area` VALUES (231101, '市辖区', 231100, 1);
INSERT INTO `codeworld_area` VALUES (231102, '爱辉区', 231101, 1);
INSERT INTO `codeworld_area` VALUES (231121, '嫩江县', 231100, 1);
INSERT INTO `codeworld_area` VALUES (231123, '逊克县', 231100, 1);
INSERT INTO `codeworld_area` VALUES (231124, '孙吴县', 231100, 1);
INSERT INTO `codeworld_area` VALUES (231181, '北安市', 231100, 1);
INSERT INTO `codeworld_area` VALUES (231182, '五大连池市', 231100, 1);
INSERT INTO `codeworld_area` VALUES (231200, '绥化市', 230000, 1);
INSERT INTO `codeworld_area` VALUES (231201, '北林区', 231200, 1);
INSERT INTO `codeworld_area` VALUES (231221, '望奎县', 231200, 1);
INSERT INTO `codeworld_area` VALUES (231222, '兰西县', 231200, 1);
INSERT INTO `codeworld_area` VALUES (231223, '青冈县', 231200, 1);
INSERT INTO `codeworld_area` VALUES (231224, '庆安县', 231200, 1);
INSERT INTO `codeworld_area` VALUES (231225, '明水县', 231200, 1);
INSERT INTO `codeworld_area` VALUES (231226, '绥棱县', 231200, 1);
INSERT INTO `codeworld_area` VALUES (231281, '安达市', 231200, 1);
INSERT INTO `codeworld_area` VALUES (231282, '肇东市', 231200, 1);
INSERT INTO `codeworld_area` VALUES (231283, '海伦市', 231200, 1);
INSERT INTO `codeworld_area` VALUES (232700, '大兴安岭地区', 230000, 1);
INSERT INTO `codeworld_area` VALUES (232701, '加格达奇区', 232700, 1);
INSERT INTO `codeworld_area` VALUES (232702, '松岭区', 232700, 1);
INSERT INTO `codeworld_area` VALUES (232703, '新林区', 232700, 1);
INSERT INTO `codeworld_area` VALUES (232704, '呼中区', 232700, 1);
INSERT INTO `codeworld_area` VALUES (232721, '呼玛县', 232700, 1);
INSERT INTO `codeworld_area` VALUES (232722, '塔河县', 232700, 1);
INSERT INTO `codeworld_area` VALUES (232723, '漠河县', 232700, 1);
INSERT INTO `codeworld_area` VALUES (310000, '上海市', 0, 1);
INSERT INTO `codeworld_area` VALUES (310100, '黄浦区', 310000, 1);
INSERT INTO `codeworld_area` VALUES (310300, '卢湾区', 310000, 1);
INSERT INTO `codeworld_area` VALUES (310400, '徐汇区', 310000, 1);
INSERT INTO `codeworld_area` VALUES (310500, '长宁区', 310000, 1);
INSERT INTO `codeworld_area` VALUES (310600, '静安区', 310000, 1);
INSERT INTO `codeworld_area` VALUES (310700, '普陀区', 310000, 1);
INSERT INTO `codeworld_area` VALUES (310800, '闸北区', 310000, 1);
INSERT INTO `codeworld_area` VALUES (310900, '虹口区', 310000, 1);
INSERT INTO `codeworld_area` VALUES (311000, '杨浦区', 310000, 1);
INSERT INTO `codeworld_area` VALUES (311200, '闵行区', 310000, 1);
INSERT INTO `codeworld_area` VALUES (311300, '宝山区', 310000, 1);
INSERT INTO `codeworld_area` VALUES (311400, '嘉定区', 310000, 1);
INSERT INTO `codeworld_area` VALUES (311500, '浦东新区', 310000, 1);
INSERT INTO `codeworld_area` VALUES (311600, '金山区', 310000, 1);
INSERT INTO `codeworld_area` VALUES (311700, '松江区', 310000, 1);
INSERT INTO `codeworld_area` VALUES (311800, '青浦区', 310000, 1);
INSERT INTO `codeworld_area` VALUES (311900, '南汇区', 310000, 1);
INSERT INTO `codeworld_area` VALUES (312000, '奉贤区', 310000, 1);
INSERT INTO `codeworld_area` VALUES (313000, '崇明县', 310000, 1);
INSERT INTO `codeworld_area` VALUES (320000, '江苏省', 0, 1);
INSERT INTO `codeworld_area` VALUES (320100, '南京市', 320000, 1);
INSERT INTO `codeworld_area` VALUES (320101, '市辖区', 320100, 1);
INSERT INTO `codeworld_area` VALUES (320102, '玄武区', 320101, 1);
INSERT INTO `codeworld_area` VALUES (320103, '白下区', 320101, 1);
INSERT INTO `codeworld_area` VALUES (320104, '秦淮区', 320101, 1);
INSERT INTO `codeworld_area` VALUES (320105, '建邺区', 320101, 1);
INSERT INTO `codeworld_area` VALUES (320106, '鼓楼区', 320101, 1);
INSERT INTO `codeworld_area` VALUES (320107, '下关区', 320101, 1);
INSERT INTO `codeworld_area` VALUES (320111, '浦口区', 320101, 1);
INSERT INTO `codeworld_area` VALUES (320113, '栖霞区', 320101, 1);
INSERT INTO `codeworld_area` VALUES (320114, '雨花台区', 320101, 1);
INSERT INTO `codeworld_area` VALUES (320115, '江宁区', 320101, 1);
INSERT INTO `codeworld_area` VALUES (320116, '六合区', 320101, 1);
INSERT INTO `codeworld_area` VALUES (320124, '溧水区', 320100, 1);
INSERT INTO `codeworld_area` VALUES (320125, '高淳区', 320100, 1);
INSERT INTO `codeworld_area` VALUES (320200, '无锡市', 320000, 1);
INSERT INTO `codeworld_area` VALUES (320201, '市辖区', 320200, 1);
INSERT INTO `codeworld_area` VALUES (320202, '崇安区', 320201, 1);
INSERT INTO `codeworld_area` VALUES (320203, '南长区', 320201, 1);
INSERT INTO `codeworld_area` VALUES (320204, '北塘区', 320201, 1);
INSERT INTO `codeworld_area` VALUES (320205, '锡山区', 320201, 1);
INSERT INTO `codeworld_area` VALUES (320206, '惠山区', 320201, 1);
INSERT INTO `codeworld_area` VALUES (320211, '滨湖区', 320201, 1);
INSERT INTO `codeworld_area` VALUES (320281, '江阴市', 320200, 1);
INSERT INTO `codeworld_area` VALUES (320282, '宜兴市', 320200, 1);
INSERT INTO `codeworld_area` VALUES (320300, '徐州市', 320000, 1);
INSERT INTO `codeworld_area` VALUES (320301, '泉山区', 320300, 1);
INSERT INTO `codeworld_area` VALUES (320302, '鼓楼区', 320300, 1);
INSERT INTO `codeworld_area` VALUES (320303, '云龙区', 320300, 1);
INSERT INTO `codeworld_area` VALUES (320304, '九里区', 320301, 1);
INSERT INTO `codeworld_area` VALUES (320305, '贾汪区', 320300, 1);
INSERT INTO `codeworld_area` VALUES (320321, '丰县', 320300, 1);
INSERT INTO `codeworld_area` VALUES (320322, '沛县', 320300, 1);
INSERT INTO `codeworld_area` VALUES (320323, '铜山县', 320300, 1);
INSERT INTO `codeworld_area` VALUES (320324, '睢宁县', 320300, 1);
INSERT INTO `codeworld_area` VALUES (320381, '新沂市', 320300, 1);
INSERT INTO `codeworld_area` VALUES (320382, '邳州市', 320300, 1);
INSERT INTO `codeworld_area` VALUES (320400, '常州市', 320000, 1);
INSERT INTO `codeworld_area` VALUES (320401, '市辖区', 320400, 1);
INSERT INTO `codeworld_area` VALUES (320402, '天宁区', 320401, 1);
INSERT INTO `codeworld_area` VALUES (320404, '钟楼区', 320401, 1);
INSERT INTO `codeworld_area` VALUES (320405, '戚墅堰区', 320401, 1);
INSERT INTO `codeworld_area` VALUES (320411, '新北区', 320401, 1);
INSERT INTO `codeworld_area` VALUES (320412, '武进区', 320401, 1);
INSERT INTO `codeworld_area` VALUES (320481, '溧阳市', 320400, 1);
INSERT INTO `codeworld_area` VALUES (320482, '金坛市', 320400, 1);
INSERT INTO `codeworld_area` VALUES (320500, '苏州市', 320000, 1);
INSERT INTO `codeworld_area` VALUES (320501, '市辖区', 320500, 1);
INSERT INTO `codeworld_area` VALUES (320502, '沧浪区', 320501, 1);
INSERT INTO `codeworld_area` VALUES (320503, '平江区', 320501, 1);
INSERT INTO `codeworld_area` VALUES (320504, '金阊区', 320501, 1);
INSERT INTO `codeworld_area` VALUES (320505, '虎丘区', 320501, 1);
INSERT INTO `codeworld_area` VALUES (320506, '吴中区', 320501, 1);
INSERT INTO `codeworld_area` VALUES (320507, '相城区', 320501, 1);
INSERT INTO `codeworld_area` VALUES (320581, '常熟市', 320500, 1);
INSERT INTO `codeworld_area` VALUES (320582, '张家港市', 320500, 1);
INSERT INTO `codeworld_area` VALUES (320583, '昆山市', 320500, 1);
INSERT INTO `codeworld_area` VALUES (320584, '吴江市', 320500, 1);
INSERT INTO `codeworld_area` VALUES (320585, '太仓市', 320500, 1);
INSERT INTO `codeworld_area` VALUES (320600, '南通市', 320000, 1);
INSERT INTO `codeworld_area` VALUES (320601, '市辖区', 320600, 1);
INSERT INTO `codeworld_area` VALUES (320602, '崇川区', 320601, 1);
INSERT INTO `codeworld_area` VALUES (320611, '港闸区', 320601, 1);
INSERT INTO `codeworld_area` VALUES (320621, '海安县', 320600, 1);
INSERT INTO `codeworld_area` VALUES (320623, '如东县', 320600, 1);
INSERT INTO `codeworld_area` VALUES (320681, '启东市', 320600, 1);
INSERT INTO `codeworld_area` VALUES (320682, '如皋市', 320600, 1);
INSERT INTO `codeworld_area` VALUES (320683, '通州市', 320600, 1);
INSERT INTO `codeworld_area` VALUES (320684, '海门市', 320600, 1);
INSERT INTO `codeworld_area` VALUES (320700, '连云港市', 320000, 1);
INSERT INTO `codeworld_area` VALUES (320701, '市辖区', 320700, 1);
INSERT INTO `codeworld_area` VALUES (320703, '连云区', 320701, 1);
INSERT INTO `codeworld_area` VALUES (320705, '新浦区', 320701, 1);
INSERT INTO `codeworld_area` VALUES (320706, '海州区', 320701, 1);
INSERT INTO `codeworld_area` VALUES (320721, '赣榆县', 320700, 1);
INSERT INTO `codeworld_area` VALUES (320722, '东海县', 320700, 1);
INSERT INTO `codeworld_area` VALUES (320723, '灌云县', 320700, 1);
INSERT INTO `codeworld_area` VALUES (320724, '灌南县', 320700, 1);
INSERT INTO `codeworld_area` VALUES (320800, '淮安市', 320000, 1);
INSERT INTO `codeworld_area` VALUES (320801, '市辖区', 320800, 1);
INSERT INTO `codeworld_area` VALUES (320802, '清河区', 320801, 1);
INSERT INTO `codeworld_area` VALUES (320803, '楚州区', 320801, 1);
INSERT INTO `codeworld_area` VALUES (320804, '淮阴区', 320801, 1);
INSERT INTO `codeworld_area` VALUES (320811, '清浦区', 320801, 1);
INSERT INTO `codeworld_area` VALUES (320826, '涟水县', 320800, 1);
INSERT INTO `codeworld_area` VALUES (320829, '洪泽县', 320800, 1);
INSERT INTO `codeworld_area` VALUES (320830, '盱眙县', 320800, 1);
INSERT INTO `codeworld_area` VALUES (320831, '金湖县', 320800, 1);
INSERT INTO `codeworld_area` VALUES (320900, '盐城市', 320000, 1);
INSERT INTO `codeworld_area` VALUES (320901, '市辖区', 320900, 1);
INSERT INTO `codeworld_area` VALUES (320902, '亭湖区', 320901, 1);
INSERT INTO `codeworld_area` VALUES (320903, '盐都区', 320901, 1);
INSERT INTO `codeworld_area` VALUES (320921, '响水县', 320900, 1);
INSERT INTO `codeworld_area` VALUES (320922, '滨海县', 320900, 1);
INSERT INTO `codeworld_area` VALUES (320923, '阜宁县', 320900, 1);
INSERT INTO `codeworld_area` VALUES (320924, '射阳县', 320900, 1);
INSERT INTO `codeworld_area` VALUES (320925, '建湖县', 320900, 1);
INSERT INTO `codeworld_area` VALUES (320981, '东台市', 320900, 1);
INSERT INTO `codeworld_area` VALUES (320982, '大丰市', 320900, 1);
INSERT INTO `codeworld_area` VALUES (321000, '扬州市', 320000, 1);
INSERT INTO `codeworld_area` VALUES (321001, '市辖区', 321000, 1);
INSERT INTO `codeworld_area` VALUES (321002, '广陵区', 321001, 1);
INSERT INTO `codeworld_area` VALUES (321003, '邗江区', 321001, 1);
INSERT INTO `codeworld_area` VALUES (321011, '维扬区', 321001, 1);
INSERT INTO `codeworld_area` VALUES (321023, '宝应县', 321000, 1);
INSERT INTO `codeworld_area` VALUES (321081, '仪征市', 321000, 1);
INSERT INTO `codeworld_area` VALUES (321084, '高邮市', 321000, 1);
INSERT INTO `codeworld_area` VALUES (321088, '江都市', 321000, 1);
INSERT INTO `codeworld_area` VALUES (321100, '镇江市', 320000, 1);
INSERT INTO `codeworld_area` VALUES (321101, '市辖区', 321100, 1);
INSERT INTO `codeworld_area` VALUES (321102, '京口区', 321101, 1);
INSERT INTO `codeworld_area` VALUES (321111, '润州区', 321101, 1);
INSERT INTO `codeworld_area` VALUES (321112, '丹徒区', 321101, 1);
INSERT INTO `codeworld_area` VALUES (321181, '丹阳市', 321100, 1);
INSERT INTO `codeworld_area` VALUES (321182, '扬中市', 321100, 1);
INSERT INTO `codeworld_area` VALUES (321183, '句容市', 321100, 1);
INSERT INTO `codeworld_area` VALUES (321200, '泰州市', 320000, 1);
INSERT INTO `codeworld_area` VALUES (321201, '市辖区', 321200, 1);
INSERT INTO `codeworld_area` VALUES (321202, '海陵区', 321201, 1);
INSERT INTO `codeworld_area` VALUES (321203, '高港区', 321201, 1);
INSERT INTO `codeworld_area` VALUES (321281, '兴化市', 321200, 1);
INSERT INTO `codeworld_area` VALUES (321282, '靖江市', 321200, 1);
INSERT INTO `codeworld_area` VALUES (321283, '泰兴市', 321200, 1);
INSERT INTO `codeworld_area` VALUES (321284, '姜堰市', 321200, 1);
INSERT INTO `codeworld_area` VALUES (321300, '宿迁市', 320000, 1);
INSERT INTO `codeworld_area` VALUES (321301, '市辖区', 321300, 1);
INSERT INTO `codeworld_area` VALUES (321302, '宿城区', 321301, 1);
INSERT INTO `codeworld_area` VALUES (321311, '宿豫区', 321301, 1);
INSERT INTO `codeworld_area` VALUES (321322, '沭阳县', 321300, 1);
INSERT INTO `codeworld_area` VALUES (321323, '泗阳县', 321300, 1);
INSERT INTO `codeworld_area` VALUES (321324, '泗洪县', 321300, 1);
INSERT INTO `codeworld_area` VALUES (330000, '浙江省', 0, 1);
INSERT INTO `codeworld_area` VALUES (330100, '杭州市', 330000, 1);
INSERT INTO `codeworld_area` VALUES (330101, '市辖区', 330100, 1);
INSERT INTO `codeworld_area` VALUES (330102, '上城区', 330101, 1);
INSERT INTO `codeworld_area` VALUES (330103, '下城区', 330101, 1);
INSERT INTO `codeworld_area` VALUES (330104, '江干区', 330101, 1);
INSERT INTO `codeworld_area` VALUES (330105, '拱墅区', 330101, 1);
INSERT INTO `codeworld_area` VALUES (330106, '西湖区', 330101, 1);
INSERT INTO `codeworld_area` VALUES (330108, '滨江区', 330101, 1);
INSERT INTO `codeworld_area` VALUES (330109, '萧山区', 330101, 1);
INSERT INTO `codeworld_area` VALUES (330110, '余杭区', 330101, 1);
INSERT INTO `codeworld_area` VALUES (330122, '桐庐县', 330100, 1);
INSERT INTO `codeworld_area` VALUES (330127, '淳安县', 330100, 1);
INSERT INTO `codeworld_area` VALUES (330182, '建德市', 330100, 1);
INSERT INTO `codeworld_area` VALUES (330183, '富阳市', 330100, 1);
INSERT INTO `codeworld_area` VALUES (330185, '临安市', 330100, 1);
INSERT INTO `codeworld_area` VALUES (330200, '宁波市', 330000, 1);
INSERT INTO `codeworld_area` VALUES (330201, '市辖区', 330200, 1);
INSERT INTO `codeworld_area` VALUES (330203, '海曙区', 330201, 1);
INSERT INTO `codeworld_area` VALUES (330204, '江东区', 330201, 1);
INSERT INTO `codeworld_area` VALUES (330205, '江北区', 330201, 1);
INSERT INTO `codeworld_area` VALUES (330206, '北仑区', 330201, 1);
INSERT INTO `codeworld_area` VALUES (330211, '镇海区', 330201, 1);
INSERT INTO `codeworld_area` VALUES (330212, '鄞州区', 330201, 1);
INSERT INTO `codeworld_area` VALUES (330225, '象山县', 330200, 1);
INSERT INTO `codeworld_area` VALUES (330226, '宁海县', 330200, 1);
INSERT INTO `codeworld_area` VALUES (330281, '余姚市', 330200, 1);
INSERT INTO `codeworld_area` VALUES (330282, '慈溪市', 330200, 1);
INSERT INTO `codeworld_area` VALUES (330283, '奉化市', 330200, 1);
INSERT INTO `codeworld_area` VALUES (330300, '温州市', 330000, 1);
INSERT INTO `codeworld_area` VALUES (330301, '市辖区', 330300, 1);
INSERT INTO `codeworld_area` VALUES (330302, '鹿城区', 330301, 1);
INSERT INTO `codeworld_area` VALUES (330303, '龙湾区', 330301, 1);
INSERT INTO `codeworld_area` VALUES (330304, '瓯海区', 330301, 1);
INSERT INTO `codeworld_area` VALUES (330322, '洞头县', 330300, 1);
INSERT INTO `codeworld_area` VALUES (330324, '永嘉县', 330300, 1);
INSERT INTO `codeworld_area` VALUES (330326, '平阳县', 330300, 1);
INSERT INTO `codeworld_area` VALUES (330327, '苍南县', 330300, 1);
INSERT INTO `codeworld_area` VALUES (330328, '文成县', 330300, 1);
INSERT INTO `codeworld_area` VALUES (330329, '泰顺县', 330300, 1);
INSERT INTO `codeworld_area` VALUES (330381, '瑞安市', 330300, 1);
INSERT INTO `codeworld_area` VALUES (330382, '乐清市', 330300, 1);
INSERT INTO `codeworld_area` VALUES (330400, '嘉兴市', 330000, 1);
INSERT INTO `codeworld_area` VALUES (330401, '市辖区', 330400, 1);
INSERT INTO `codeworld_area` VALUES (330402, '南湖区', 330401, 1);
INSERT INTO `codeworld_area` VALUES (330411, '秀洲区', 330401, 1);
INSERT INTO `codeworld_area` VALUES (330421, '嘉善县', 330400, 1);
INSERT INTO `codeworld_area` VALUES (330424, '海盐县', 330400, 1);
INSERT INTO `codeworld_area` VALUES (330481, '海宁市', 330400, 1);
INSERT INTO `codeworld_area` VALUES (330482, '平湖市', 330400, 1);
INSERT INTO `codeworld_area` VALUES (330483, '桐乡市', 330400, 1);
INSERT INTO `codeworld_area` VALUES (330500, '湖州市', 330000, 1);
INSERT INTO `codeworld_area` VALUES (330501, '市辖区', 330500, 1);
INSERT INTO `codeworld_area` VALUES (330502, '吴兴区', 330501, 1);
INSERT INTO `codeworld_area` VALUES (330503, '南浔区', 330501, 1);
INSERT INTO `codeworld_area` VALUES (330521, '德清县', 330500, 1);
INSERT INTO `codeworld_area` VALUES (330522, '长兴县', 330500, 1);
INSERT INTO `codeworld_area` VALUES (330523, '安吉县', 330500, 1);
INSERT INTO `codeworld_area` VALUES (330600, '绍兴市', 330000, 1);
INSERT INTO `codeworld_area` VALUES (330601, '市辖区', 330600, 1);
INSERT INTO `codeworld_area` VALUES (330602, '越城区', 330601, 1);
INSERT INTO `codeworld_area` VALUES (330621, '绍兴县', 330600, 1);
INSERT INTO `codeworld_area` VALUES (330624, '新昌县', 330600, 1);
INSERT INTO `codeworld_area` VALUES (330681, '诸暨市', 330600, 1);
INSERT INTO `codeworld_area` VALUES (330682, '上虞市', 330600, 1);
INSERT INTO `codeworld_area` VALUES (330683, '嵊州市', 330600, 1);
INSERT INTO `codeworld_area` VALUES (330700, '金华市', 330000, 1);
INSERT INTO `codeworld_area` VALUES (330701, '市辖区', 330700, 1);
INSERT INTO `codeworld_area` VALUES (330702, '婺城区', 330701, 1);
INSERT INTO `codeworld_area` VALUES (330703, '金东区', 330701, 1);
INSERT INTO `codeworld_area` VALUES (330723, '武义县', 330700, 1);
INSERT INTO `codeworld_area` VALUES (330726, '浦江县', 330700, 1);
INSERT INTO `codeworld_area` VALUES (330727, '磐安县', 330700, 1);
INSERT INTO `codeworld_area` VALUES (330781, '兰溪市', 330700, 1);
INSERT INTO `codeworld_area` VALUES (330782, '义乌市', 330700, 1);
INSERT INTO `codeworld_area` VALUES (330783, '东阳市', 330700, 1);
INSERT INTO `codeworld_area` VALUES (330784, '永康市', 330700, 1);
INSERT INTO `codeworld_area` VALUES (330800, '衢州市', 330000, 1);
INSERT INTO `codeworld_area` VALUES (330801, '市辖区', 330800, 1);
INSERT INTO `codeworld_area` VALUES (330802, '柯城区', 330801, 1);
INSERT INTO `codeworld_area` VALUES (330803, '衢江区', 330801, 1);
INSERT INTO `codeworld_area` VALUES (330822, '常山县', 330800, 1);
INSERT INTO `codeworld_area` VALUES (330824, '开化县', 330800, 1);
INSERT INTO `codeworld_area` VALUES (330825, '龙游县', 330800, 1);
INSERT INTO `codeworld_area` VALUES (330881, '江山市', 330800, 1);
INSERT INTO `codeworld_area` VALUES (330900, '舟山市', 330000, 1);
INSERT INTO `codeworld_area` VALUES (330901, '市辖区', 330900, 1);
INSERT INTO `codeworld_area` VALUES (330902, '定海区', 330901, 1);
INSERT INTO `codeworld_area` VALUES (330903, '普陀区', 330901, 1);
INSERT INTO `codeworld_area` VALUES (330921, '岱山县', 330900, 1);
INSERT INTO `codeworld_area` VALUES (330922, '嵊泗县', 330900, 1);
INSERT INTO `codeworld_area` VALUES (331000, '台州市', 330000, 1);
INSERT INTO `codeworld_area` VALUES (331001, '市辖区', 331000, 1);
INSERT INTO `codeworld_area` VALUES (331002, '椒江区', 331001, 1);
INSERT INTO `codeworld_area` VALUES (331003, '黄岩区', 331001, 1);
INSERT INTO `codeworld_area` VALUES (331004, '路桥区', 331001, 1);
INSERT INTO `codeworld_area` VALUES (331021, '玉环县', 331000, 1);
INSERT INTO `codeworld_area` VALUES (331022, '三门县', 331000, 1);
INSERT INTO `codeworld_area` VALUES (331023, '天台县', 331000, 1);
INSERT INTO `codeworld_area` VALUES (331024, '仙居县', 331000, 1);
INSERT INTO `codeworld_area` VALUES (331081, '温岭市', 331000, 1);
INSERT INTO `codeworld_area` VALUES (331082, '临海市', 331000, 1);
INSERT INTO `codeworld_area` VALUES (331100, '丽水市', 330000, 1);
INSERT INTO `codeworld_area` VALUES (331101, '市辖区', 331100, 1);
INSERT INTO `codeworld_area` VALUES (331102, '莲都区', 331101, 1);
INSERT INTO `codeworld_area` VALUES (331121, '青田县', 331100, 1);
INSERT INTO `codeworld_area` VALUES (331122, '缙云县', 331100, 1);
INSERT INTO `codeworld_area` VALUES (331123, '遂昌县', 331100, 1);
INSERT INTO `codeworld_area` VALUES (331124, '松阳县', 331100, 1);
INSERT INTO `codeworld_area` VALUES (331125, '云和县', 331100, 1);
INSERT INTO `codeworld_area` VALUES (331126, '庆元县', 331100, 1);
INSERT INTO `codeworld_area` VALUES (331127, '景宁畲族自治县', 331100, 1);
INSERT INTO `codeworld_area` VALUES (331181, '龙泉市', 331100, 1);
INSERT INTO `codeworld_area` VALUES (340000, '安徽省', 0, 1);
INSERT INTO `codeworld_area` VALUES (340100, '合肥市', 340000, 1);
INSERT INTO `codeworld_area` VALUES (340101, '市辖区', 340100, 1);
INSERT INTO `codeworld_area` VALUES (340102, '瑶海区', 340101, 1);
INSERT INTO `codeworld_area` VALUES (340103, '庐阳区', 340101, 1);
INSERT INTO `codeworld_area` VALUES (340104, '蜀山区', 340101, 1);
INSERT INTO `codeworld_area` VALUES (340111, '包河区', 340101, 1);
INSERT INTO `codeworld_area` VALUES (340121, '长丰县', 340100, 1);
INSERT INTO `codeworld_area` VALUES (340122, '肥东县', 340100, 1);
INSERT INTO `codeworld_area` VALUES (340123, '肥西县', 340100, 1);
INSERT INTO `codeworld_area` VALUES (340124, '庐江县', 340100, 1);
INSERT INTO `codeworld_area` VALUES (340181, '巢湖市', 340100, 1);
INSERT INTO `codeworld_area` VALUES (340200, '芜湖市', 340000, 1);
INSERT INTO `codeworld_area` VALUES (340201, '市辖区', 340200, 1);
INSERT INTO `codeworld_area` VALUES (340202, '镜湖区', 340201, 1);
INSERT INTO `codeworld_area` VALUES (340203, '马塘区', 340201, 1);
INSERT INTO `codeworld_area` VALUES (340207, '鸠江区', 340201, 1);
INSERT INTO `codeworld_area` VALUES (340221, '芜湖县', 340200, 1);
INSERT INTO `codeworld_area` VALUES (340222, '繁昌县', 340200, 1);
INSERT INTO `codeworld_area` VALUES (340223, '南陵县', 340200, 1);
INSERT INTO `codeworld_area` VALUES (340225, '无为县', 340200, 1);
INSERT INTO `codeworld_area` VALUES (340300, '蚌埠市', 340000, 1);
INSERT INTO `codeworld_area` VALUES (340301, '市辖区', 340300, 1);
INSERT INTO `codeworld_area` VALUES (340302, '龙子湖区', 340301, 1);
INSERT INTO `codeworld_area` VALUES (340303, '蚌山区', 340301, 1);
INSERT INTO `codeworld_area` VALUES (340304, '禹会区', 340301, 1);
INSERT INTO `codeworld_area` VALUES (340311, '淮上区', 340301, 1);
INSERT INTO `codeworld_area` VALUES (340321, '怀远县', 340300, 1);
INSERT INTO `codeworld_area` VALUES (340322, '五河县', 340300, 1);
INSERT INTO `codeworld_area` VALUES (340323, '固镇县', 340300, 1);
INSERT INTO `codeworld_area` VALUES (340400, '淮南市', 340000, 1);
INSERT INTO `codeworld_area` VALUES (340401, '市辖区', 340400, 1);
INSERT INTO `codeworld_area` VALUES (340402, '大通区', 340401, 1);
INSERT INTO `codeworld_area` VALUES (340403, '田家庵区', 340401, 1);
INSERT INTO `codeworld_area` VALUES (340404, '谢家集区', 340401, 1);
INSERT INTO `codeworld_area` VALUES (340405, '八公山区', 340401, 1);
INSERT INTO `codeworld_area` VALUES (340406, '潘集区', 340401, 1);
INSERT INTO `codeworld_area` VALUES (340421, '凤台县', 340400, 1);
INSERT INTO `codeworld_area` VALUES (340500, '马鞍山市', 340000, 1);
INSERT INTO `codeworld_area` VALUES (340501, '市辖区', 340500, 1);
INSERT INTO `codeworld_area` VALUES (340502, '金家庄区', 340501, 1);
INSERT INTO `codeworld_area` VALUES (340503, '花山区', 340501, 1);
INSERT INTO `codeworld_area` VALUES (340504, '雨山区', 340501, 1);
INSERT INTO `codeworld_area` VALUES (340521, '当涂县', 340500, 1);
INSERT INTO `codeworld_area` VALUES (340522, '含山县', 340500, 1);
INSERT INTO `codeworld_area` VALUES (340523, '和县', 340500, 1);
INSERT INTO `codeworld_area` VALUES (340600, '淮北市', 340000, 1);
INSERT INTO `codeworld_area` VALUES (340601, '市辖区', 340600, 1);
INSERT INTO `codeworld_area` VALUES (340602, '杜集区', 340601, 1);
INSERT INTO `codeworld_area` VALUES (340603, '相山区', 340601, 1);
INSERT INTO `codeworld_area` VALUES (340604, '烈山区', 340601, 1);
INSERT INTO `codeworld_area` VALUES (340621, '濉溪县', 340600, 1);
INSERT INTO `codeworld_area` VALUES (340700, '铜陵市', 340000, 1);
INSERT INTO `codeworld_area` VALUES (340701, '市辖区', 340700, 1);
INSERT INTO `codeworld_area` VALUES (340702, '铜官山区', 340701, 1);
INSERT INTO `codeworld_area` VALUES (340703, '狮子山区', 340701, 1);
INSERT INTO `codeworld_area` VALUES (340711, '郊区', 340701, 1);
INSERT INTO `codeworld_area` VALUES (340721, '铜陵县', 340700, 1);
INSERT INTO `codeworld_area` VALUES (340800, '安庆市', 340000, 1);
INSERT INTO `codeworld_area` VALUES (340801, '市辖区', 340800, 1);
INSERT INTO `codeworld_area` VALUES (340802, '迎江区', 340801, 1);
INSERT INTO `codeworld_area` VALUES (340803, '大观区', 340801, 1);
INSERT INTO `codeworld_area` VALUES (340811, '宜秀区', 340801, 1);
INSERT INTO `codeworld_area` VALUES (340822, '怀宁县', 340800, 1);
INSERT INTO `codeworld_area` VALUES (340823, '枞阳县', 340800, 1);
INSERT INTO `codeworld_area` VALUES (340824, '潜山县', 340800, 1);
INSERT INTO `codeworld_area` VALUES (340825, '太湖县', 340800, 1);
INSERT INTO `codeworld_area` VALUES (340826, '宿松县', 340800, 1);
INSERT INTO `codeworld_area` VALUES (340827, '望江县', 340800, 1);
INSERT INTO `codeworld_area` VALUES (340828, '岳西县', 340800, 1);
INSERT INTO `codeworld_area` VALUES (340881, '桐城市', 340800, 1);
INSERT INTO `codeworld_area` VALUES (341000, '黄山市', 340000, 1);
INSERT INTO `codeworld_area` VALUES (341001, '黄山区', 341000, 1);
INSERT INTO `codeworld_area` VALUES (341002, '屯溪区', 341000, 1);
INSERT INTO `codeworld_area` VALUES (341004, '徽州区', 341000, 1);
INSERT INTO `codeworld_area` VALUES (341021, '歙县', 341000, 1);
INSERT INTO `codeworld_area` VALUES (341022, '休宁县', 341000, 1);
INSERT INTO `codeworld_area` VALUES (341023, '黟县', 341000, 1);
INSERT INTO `codeworld_area` VALUES (341024, '祁门县', 341000, 1);
INSERT INTO `codeworld_area` VALUES (341091, '汤口镇', 341000, 1);
INSERT INTO `codeworld_area` VALUES (341100, '滁州市', 340000, 1);
INSERT INTO `codeworld_area` VALUES (341101, '市辖区', 341100, 1);
INSERT INTO `codeworld_area` VALUES (341102, '琅琊区', 341101, 1);
INSERT INTO `codeworld_area` VALUES (341103, '南谯区', 341101, 1);
INSERT INTO `codeworld_area` VALUES (341122, '来安县', 341100, 1);
INSERT INTO `codeworld_area` VALUES (341124, '全椒县', 341100, 1);
INSERT INTO `codeworld_area` VALUES (341125, '定远县', 341100, 1);
INSERT INTO `codeworld_area` VALUES (341126, '凤阳县', 341100, 1);
INSERT INTO `codeworld_area` VALUES (341181, '天长市', 341100, 1);
INSERT INTO `codeworld_area` VALUES (341182, '明光市', 341100, 1);
INSERT INTO `codeworld_area` VALUES (341200, '阜阳市', 340000, 1);
INSERT INTO `codeworld_area` VALUES (341201, '颍泉区', 341200, 1);
INSERT INTO `codeworld_area` VALUES (341202, '颍州区', 341200, 1);
INSERT INTO `codeworld_area` VALUES (341203, '颍东区', 341200, 1);
INSERT INTO `codeworld_area` VALUES (341221, '临泉县', 341200, 1);
INSERT INTO `codeworld_area` VALUES (341222, '太和县', 341200, 1);
INSERT INTO `codeworld_area` VALUES (341225, '阜南县', 341200, 1);
INSERT INTO `codeworld_area` VALUES (341226, '颍上县', 341200, 1);
INSERT INTO `codeworld_area` VALUES (341282, '界首市', 341200, 1);
INSERT INTO `codeworld_area` VALUES (341300, '宿州市', 340000, 1);
INSERT INTO `codeworld_area` VALUES (341301, '市辖区', 341300, 1);
INSERT INTO `codeworld_area` VALUES (341302, '埇桥区', 341301, 1);
INSERT INTO `codeworld_area` VALUES (341321, '砀山县', 341300, 1);
INSERT INTO `codeworld_area` VALUES (341322, '萧县', 341300, 1);
INSERT INTO `codeworld_area` VALUES (341323, '灵璧县', 341300, 1);
INSERT INTO `codeworld_area` VALUES (341324, '泗县', 341300, 1);
INSERT INTO `codeworld_area` VALUES (341402, '居巢区', 340181, 1);
INSERT INTO `codeworld_area` VALUES (341500, '六安市', 340000, 1);
INSERT INTO `codeworld_area` VALUES (341501, '市辖区', 341500, 1);
INSERT INTO `codeworld_area` VALUES (341502, '金安区', 341501, 1);
INSERT INTO `codeworld_area` VALUES (341503, '裕安区', 341501, 1);
INSERT INTO `codeworld_area` VALUES (341521, '寿县', 341500, 1);
INSERT INTO `codeworld_area` VALUES (341522, '霍邱县', 341500, 1);
INSERT INTO `codeworld_area` VALUES (341523, '舒城县', 341500, 1);
INSERT INTO `codeworld_area` VALUES (341524, '金寨县', 341500, 1);
INSERT INTO `codeworld_area` VALUES (341525, '霍山县', 341500, 1);
INSERT INTO `codeworld_area` VALUES (341600, '亳州市', 340000, 1);
INSERT INTO `codeworld_area` VALUES (341601, '谯城区', 341600, 1);
INSERT INTO `codeworld_area` VALUES (341621, '涡阳县', 341600, 1);
INSERT INTO `codeworld_area` VALUES (341622, '蒙城县', 341600, 1);
INSERT INTO `codeworld_area` VALUES (341623, '利辛县', 341600, 1);
INSERT INTO `codeworld_area` VALUES (341700, '池州市', 340000, 1);
INSERT INTO `codeworld_area` VALUES (341701, '市辖区', 341700, 1);
INSERT INTO `codeworld_area` VALUES (341702, '贵池区', 341701, 1);
INSERT INTO `codeworld_area` VALUES (341721, '东至县', 341700, 1);
INSERT INTO `codeworld_area` VALUES (341722, '石台县', 341700, 1);
INSERT INTO `codeworld_area` VALUES (341723, '青阳县', 341700, 1);
INSERT INTO `codeworld_area` VALUES (341800, '宣城市', 340000, 1);
INSERT INTO `codeworld_area` VALUES (341801, '市辖区', 341800, 1);
INSERT INTO `codeworld_area` VALUES (341802, '宣州区', 341801, 1);
INSERT INTO `codeworld_area` VALUES (341821, '郎溪县', 341800, 1);
INSERT INTO `codeworld_area` VALUES (341822, '广德县', 341800, 1);
INSERT INTO `codeworld_area` VALUES (341823, '泾县', 341800, 1);
INSERT INTO `codeworld_area` VALUES (341824, '绩溪县', 341800, 1);
INSERT INTO `codeworld_area` VALUES (341825, '旌德县', 341800, 1);
INSERT INTO `codeworld_area` VALUES (341881, '宁国市', 341800, 1);
INSERT INTO `codeworld_area` VALUES (350000, '福建省', 0, 1);
INSERT INTO `codeworld_area` VALUES (350100, '福州市', 350000, 1);
INSERT INTO `codeworld_area` VALUES (350101, '市辖区', 350100, 1);
INSERT INTO `codeworld_area` VALUES (350102, '鼓楼区', 350101, 1);
INSERT INTO `codeworld_area` VALUES (350103, '台江区', 350101, 1);
INSERT INTO `codeworld_area` VALUES (350104, '仓山区', 350101, 1);
INSERT INTO `codeworld_area` VALUES (350105, '马尾区', 350101, 1);
INSERT INTO `codeworld_area` VALUES (350111, '晋安区', 350101, 1);
INSERT INTO `codeworld_area` VALUES (350121, '闽侯县', 350100, 1);
INSERT INTO `codeworld_area` VALUES (350122, '连江县', 350100, 1);
INSERT INTO `codeworld_area` VALUES (350123, '罗源县', 350100, 1);
INSERT INTO `codeworld_area` VALUES (350124, '闽清县', 350100, 1);
INSERT INTO `codeworld_area` VALUES (350125, '永泰县', 350100, 1);
INSERT INTO `codeworld_area` VALUES (350128, '平潭县', 350100, 1);
INSERT INTO `codeworld_area` VALUES (350181, '福清市', 350100, 1);
INSERT INTO `codeworld_area` VALUES (350182, '长乐市', 350100, 1);
INSERT INTO `codeworld_area` VALUES (350200, '厦门市', 350000, 1);
INSERT INTO `codeworld_area` VALUES (350201, '市辖区', 350200, 1);
INSERT INTO `codeworld_area` VALUES (350203, '思明区', 350201, 1);
INSERT INTO `codeworld_area` VALUES (350205, '海沧区', 350201, 1);
INSERT INTO `codeworld_area` VALUES (350206, '湖里区', 350201, 1);
INSERT INTO `codeworld_area` VALUES (350211, '集美区', 350201, 1);
INSERT INTO `codeworld_area` VALUES (350212, '同安区', 350201, 1);
INSERT INTO `codeworld_area` VALUES (350213, '翔安区', 350201, 1);
INSERT INTO `codeworld_area` VALUES (350300, '莆田市', 350000, 1);
INSERT INTO `codeworld_area` VALUES (350301, '市辖区', 350300, 1);
INSERT INTO `codeworld_area` VALUES (350302, '城厢区', 350301, 1);
INSERT INTO `codeworld_area` VALUES (350303, '涵江区', 350301, 1);
INSERT INTO `codeworld_area` VALUES (350304, '荔城区', 350301, 1);
INSERT INTO `codeworld_area` VALUES (350305, '秀屿区', 350301, 1);
INSERT INTO `codeworld_area` VALUES (350322, '仙游县', 350300, 1);
INSERT INTO `codeworld_area` VALUES (350400, '三明市', 350000, 1);
INSERT INTO `codeworld_area` VALUES (350401, '市辖区', 350400, 1);
INSERT INTO `codeworld_area` VALUES (350402, '梅列区', 350401, 1);
INSERT INTO `codeworld_area` VALUES (350403, '三元区', 350401, 1);
INSERT INTO `codeworld_area` VALUES (350421, '明溪县', 350400, 1);
INSERT INTO `codeworld_area` VALUES (350423, '清流县', 350400, 1);
INSERT INTO `codeworld_area` VALUES (350424, '宁化县', 350400, 1);
INSERT INTO `codeworld_area` VALUES (350425, '大田县', 350400, 1);
INSERT INTO `codeworld_area` VALUES (350426, '尤溪县', 350400, 1);
INSERT INTO `codeworld_area` VALUES (350427, '沙县', 350400, 1);
INSERT INTO `codeworld_area` VALUES (350428, '将乐县', 350400, 1);
INSERT INTO `codeworld_area` VALUES (350429, '泰宁县', 350400, 1);
INSERT INTO `codeworld_area` VALUES (350430, '建宁县', 350400, 1);
INSERT INTO `codeworld_area` VALUES (350481, '永安市', 350400, 1);
INSERT INTO `codeworld_area` VALUES (350500, '泉州市', 350000, 1);
INSERT INTO `codeworld_area` VALUES (350501, '市辖区', 350500, 1);
INSERT INTO `codeworld_area` VALUES (350502, '鲤城区', 350501, 1);
INSERT INTO `codeworld_area` VALUES (350503, '丰泽区', 350501, 1);
INSERT INTO `codeworld_area` VALUES (350504, '洛江区', 350501, 1);
INSERT INTO `codeworld_area` VALUES (350505, '泉港区', 350501, 1);
INSERT INTO `codeworld_area` VALUES (350521, '惠安县', 350500, 1);
INSERT INTO `codeworld_area` VALUES (350524, '安溪县', 350500, 1);
INSERT INTO `codeworld_area` VALUES (350525, '永春县', 350500, 1);
INSERT INTO `codeworld_area` VALUES (350526, '德化县', 350500, 1);
INSERT INTO `codeworld_area` VALUES (350527, '金门县', 350500, 1);
INSERT INTO `codeworld_area` VALUES (350581, '石狮市', 350500, 1);
INSERT INTO `codeworld_area` VALUES (350582, '晋江市', 350500, 1);
INSERT INTO `codeworld_area` VALUES (350583, '南安市', 350500, 1);
INSERT INTO `codeworld_area` VALUES (350600, '漳州市', 350000, 1);
INSERT INTO `codeworld_area` VALUES (350601, '市辖区', 350600, 1);
INSERT INTO `codeworld_area` VALUES (350602, '芗城区', 350601, 1);
INSERT INTO `codeworld_area` VALUES (350603, '龙文区', 350601, 1);
INSERT INTO `codeworld_area` VALUES (350622, '云霄县', 350600, 1);
INSERT INTO `codeworld_area` VALUES (350623, '漳浦县', 350600, 1);
INSERT INTO `codeworld_area` VALUES (350624, '诏安县', 350600, 1);
INSERT INTO `codeworld_area` VALUES (350625, '长泰县', 350600, 1);
INSERT INTO `codeworld_area` VALUES (350626, '东山县', 350600, 1);
INSERT INTO `codeworld_area` VALUES (350627, '南靖县', 350600, 1);
INSERT INTO `codeworld_area` VALUES (350628, '平和县', 350600, 1);
INSERT INTO `codeworld_area` VALUES (350629, '华安县', 350600, 1);
INSERT INTO `codeworld_area` VALUES (350681, '龙海市', 350600, 1);
INSERT INTO `codeworld_area` VALUES (350700, '南平市', 350000, 1);
INSERT INTO `codeworld_area` VALUES (350701, '市辖区', 350700, 1);
INSERT INTO `codeworld_area` VALUES (350702, '延平区', 350701, 1);
INSERT INTO `codeworld_area` VALUES (350721, '顺昌县', 350700, 1);
INSERT INTO `codeworld_area` VALUES (350722, '浦城县', 350700, 1);
INSERT INTO `codeworld_area` VALUES (350723, '光泽县', 350700, 1);
INSERT INTO `codeworld_area` VALUES (350724, '松溪县', 350700, 1);
INSERT INTO `codeworld_area` VALUES (350725, '政和县', 350700, 1);
INSERT INTO `codeworld_area` VALUES (350781, '邵武市', 350700, 1);
INSERT INTO `codeworld_area` VALUES (350782, '武夷山市', 350700, 1);
INSERT INTO `codeworld_area` VALUES (350783, '建瓯市', 350700, 1);
INSERT INTO `codeworld_area` VALUES (350784, '建阳市', 350700, 1);
INSERT INTO `codeworld_area` VALUES (350800, '龙岩市', 350000, 1);
INSERT INTO `codeworld_area` VALUES (350801, '市辖区', 350800, 1);
INSERT INTO `codeworld_area` VALUES (350802, '新罗区', 350801, 1);
INSERT INTO `codeworld_area` VALUES (350821, '长汀县', 350800, 1);
INSERT INTO `codeworld_area` VALUES (350822, '永定县', 350800, 1);
INSERT INTO `codeworld_area` VALUES (350823, '上杭县', 350800, 1);
INSERT INTO `codeworld_area` VALUES (350824, '武平县', 350800, 1);
INSERT INTO `codeworld_area` VALUES (350825, '连城县', 350800, 1);
INSERT INTO `codeworld_area` VALUES (350881, '漳平市', 350800, 1);
INSERT INTO `codeworld_area` VALUES (350900, '宁德市', 350000, 1);
INSERT INTO `codeworld_area` VALUES (350901, '市辖区', 350900, 1);
INSERT INTO `codeworld_area` VALUES (350902, '蕉城区', 350901, 1);
INSERT INTO `codeworld_area` VALUES (350921, '霞浦县', 350900, 1);
INSERT INTO `codeworld_area` VALUES (350922, '古田县', 350900, 1);
INSERT INTO `codeworld_area` VALUES (350923, '屏南县', 350900, 1);
INSERT INTO `codeworld_area` VALUES (350924, '寿宁县', 350900, 1);
INSERT INTO `codeworld_area` VALUES (350925, '周宁县', 350900, 1);
INSERT INTO `codeworld_area` VALUES (350926, '柘荣县', 350900, 1);
INSERT INTO `codeworld_area` VALUES (350981, '福安市', 350900, 1);
INSERT INTO `codeworld_area` VALUES (350982, '福鼎市', 350900, 1);
INSERT INTO `codeworld_area` VALUES (360000, '江西省', 0, 1);
INSERT INTO `codeworld_area` VALUES (360100, '南昌市', 360000, 1);
INSERT INTO `codeworld_area` VALUES (360101, '市辖区', 360100, 1);
INSERT INTO `codeworld_area` VALUES (360102, '东湖区', 360101, 1);
INSERT INTO `codeworld_area` VALUES (360103, '西湖区', 360101, 1);
INSERT INTO `codeworld_area` VALUES (360104, '青云谱区', 360101, 1);
INSERT INTO `codeworld_area` VALUES (360105, '湾里区', 360101, 1);
INSERT INTO `codeworld_area` VALUES (360111, '青山湖区', 360101, 1);
INSERT INTO `codeworld_area` VALUES (360121, '南昌县', 360100, 1);
INSERT INTO `codeworld_area` VALUES (360122, '新建县', 360100, 1);
INSERT INTO `codeworld_area` VALUES (360123, '安义县', 360100, 1);
INSERT INTO `codeworld_area` VALUES (360124, '进贤县', 360100, 1);
INSERT INTO `codeworld_area` VALUES (360200, '景德镇市', 360000, 1);
INSERT INTO `codeworld_area` VALUES (360201, '市辖区', 360200, 1);
INSERT INTO `codeworld_area` VALUES (360202, '昌江区', 360201, 1);
INSERT INTO `codeworld_area` VALUES (360203, '珠山区', 360201, 1);
INSERT INTO `codeworld_area` VALUES (360222, '浮梁县', 360200, 1);
INSERT INTO `codeworld_area` VALUES (360281, '乐平市', 360200, 1);
INSERT INTO `codeworld_area` VALUES (360300, '萍乡市', 360000, 1);
INSERT INTO `codeworld_area` VALUES (360301, '市辖区', 360300, 1);
INSERT INTO `codeworld_area` VALUES (360302, '安源区', 360301, 1);
INSERT INTO `codeworld_area` VALUES (360313, '湘东区', 360301, 1);
INSERT INTO `codeworld_area` VALUES (360321, '莲花县', 360300, 1);
INSERT INTO `codeworld_area` VALUES (360322, '上栗县', 360300, 1);
INSERT INTO `codeworld_area` VALUES (360323, '芦溪县', 360300, 1);
INSERT INTO `codeworld_area` VALUES (360400, '九江市', 360000, 1);
INSERT INTO `codeworld_area` VALUES (360401, '市辖区', 360400, 1);
INSERT INTO `codeworld_area` VALUES (360402, '庐山区', 360401, 1);
INSERT INTO `codeworld_area` VALUES (360403, '浔阳区', 360401, 1);
INSERT INTO `codeworld_area` VALUES (360421, '九江县', 360400, 1);
INSERT INTO `codeworld_area` VALUES (360423, '武宁县', 360400, 1);
INSERT INTO `codeworld_area` VALUES (360424, '修水县', 360400, 1);
INSERT INTO `codeworld_area` VALUES (360425, '永修县', 360400, 1);
INSERT INTO `codeworld_area` VALUES (360426, '德安县', 360400, 1);
INSERT INTO `codeworld_area` VALUES (360427, '星子县', 360400, 1);
INSERT INTO `codeworld_area` VALUES (360428, '都昌县', 360400, 1);
INSERT INTO `codeworld_area` VALUES (360429, '湖口县', 360400, 1);
INSERT INTO `codeworld_area` VALUES (360430, '彭泽县', 360400, 1);
INSERT INTO `codeworld_area` VALUES (360481, '瑞昌市', 360400, 1);
INSERT INTO `codeworld_area` VALUES (360482, '共青城市', 360400, 1);
INSERT INTO `codeworld_area` VALUES (360500, '新余市', 360000, 1);
INSERT INTO `codeworld_area` VALUES (360501, '市辖区', 360500, 1);
INSERT INTO `codeworld_area` VALUES (360502, '渝水区', 360501, 1);
INSERT INTO `codeworld_area` VALUES (360521, '分宜县', 360500, 1);
INSERT INTO `codeworld_area` VALUES (360600, '鹰潭市', 360000, 1);
INSERT INTO `codeworld_area` VALUES (360601, '市辖区', 360600, 1);
INSERT INTO `codeworld_area` VALUES (360602, '月湖区', 360601, 1);
INSERT INTO `codeworld_area` VALUES (360622, '余江县', 360600, 1);
INSERT INTO `codeworld_area` VALUES (360681, '贵溪市', 360600, 1);
INSERT INTO `codeworld_area` VALUES (360700, '赣州市', 360000, 1);
INSERT INTO `codeworld_area` VALUES (360701, '市辖区', 360700, 1);
INSERT INTO `codeworld_area` VALUES (360702, '章贡区', 360701, 1);
INSERT INTO `codeworld_area` VALUES (360721, '赣县', 360700, 1);
INSERT INTO `codeworld_area` VALUES (360722, '信丰县', 360700, 1);
INSERT INTO `codeworld_area` VALUES (360723, '大余县', 360700, 1);
INSERT INTO `codeworld_area` VALUES (360724, '上犹县', 360700, 1);
INSERT INTO `codeworld_area` VALUES (360725, '崇义县', 360700, 1);
INSERT INTO `codeworld_area` VALUES (360726, '安远县', 360700, 1);
INSERT INTO `codeworld_area` VALUES (360727, '龙南县', 360700, 1);
INSERT INTO `codeworld_area` VALUES (360728, '定南县', 360700, 1);
INSERT INTO `codeworld_area` VALUES (360729, '全南县', 360700, 1);
INSERT INTO `codeworld_area` VALUES (360730, '宁都县', 360700, 1);
INSERT INTO `codeworld_area` VALUES (360731, '于都县', 360700, 1);
INSERT INTO `codeworld_area` VALUES (360732, '兴国县', 360700, 1);
INSERT INTO `codeworld_area` VALUES (360733, '会昌县', 360700, 1);
INSERT INTO `codeworld_area` VALUES (360734, '寻乌县', 360700, 1);
INSERT INTO `codeworld_area` VALUES (360735, '石城县', 360700, 1);
INSERT INTO `codeworld_area` VALUES (360781, '瑞金市', 360700, 1);
INSERT INTO `codeworld_area` VALUES (360782, '南康市', 360700, 1);
INSERT INTO `codeworld_area` VALUES (360800, '吉安市', 360000, 1);
INSERT INTO `codeworld_area` VALUES (360801, '市辖区', 360800, 1);
INSERT INTO `codeworld_area` VALUES (360802, '吉州区', 360801, 1);
INSERT INTO `codeworld_area` VALUES (360803, '青原区', 360801, 1);
INSERT INTO `codeworld_area` VALUES (360821, '吉安县', 360800, 1);
INSERT INTO `codeworld_area` VALUES (360822, '吉水县', 360800, 1);
INSERT INTO `codeworld_area` VALUES (360823, '峡江县', 360800, 1);
INSERT INTO `codeworld_area` VALUES (360824, '新干县', 360800, 1);
INSERT INTO `codeworld_area` VALUES (360825, '永丰县', 360800, 1);
INSERT INTO `codeworld_area` VALUES (360826, '泰和县', 360800, 1);
INSERT INTO `codeworld_area` VALUES (360827, '遂川县', 360800, 1);
INSERT INTO `codeworld_area` VALUES (360828, '万安县', 360800, 1);
INSERT INTO `codeworld_area` VALUES (360829, '安福县', 360800, 1);
INSERT INTO `codeworld_area` VALUES (360830, '永新县', 360800, 1);
INSERT INTO `codeworld_area` VALUES (360881, '井冈山市', 360800, 1);
INSERT INTO `codeworld_area` VALUES (360900, '宜春市', 360000, 1);
INSERT INTO `codeworld_area` VALUES (360901, '市辖区', 360900, 1);
INSERT INTO `codeworld_area` VALUES (360902, '袁州区', 360901, 1);
INSERT INTO `codeworld_area` VALUES (360921, '奉新县', 360900, 1);
INSERT INTO `codeworld_area` VALUES (360922, '万载县', 360900, 1);
INSERT INTO `codeworld_area` VALUES (360923, '上高县', 360900, 1);
INSERT INTO `codeworld_area` VALUES (360924, '宜丰县', 360900, 1);
INSERT INTO `codeworld_area` VALUES (360925, '靖安县', 360900, 1);
INSERT INTO `codeworld_area` VALUES (360926, '铜鼓县', 360900, 1);
INSERT INTO `codeworld_area` VALUES (360981, '丰城市', 360900, 1);
INSERT INTO `codeworld_area` VALUES (360982, '樟树市', 360900, 1);
INSERT INTO `codeworld_area` VALUES (360983, '高安市', 360900, 1);
INSERT INTO `codeworld_area` VALUES (361000, '抚州市', 360000, 1);
INSERT INTO `codeworld_area` VALUES (361001, '市辖区', 361000, 1);
INSERT INTO `codeworld_area` VALUES (361002, '临川区', 361001, 1);
INSERT INTO `codeworld_area` VALUES (361021, '南城县', 361000, 1);
INSERT INTO `codeworld_area` VALUES (361022, '黎川县', 361000, 1);
INSERT INTO `codeworld_area` VALUES (361023, '南丰县', 361000, 1);
INSERT INTO `codeworld_area` VALUES (361024, '崇仁县', 361000, 1);
INSERT INTO `codeworld_area` VALUES (361025, '乐安县', 361000, 1);
INSERT INTO `codeworld_area` VALUES (361026, '宜黄县', 361000, 1);
INSERT INTO `codeworld_area` VALUES (361027, '金溪县', 361000, 1);
INSERT INTO `codeworld_area` VALUES (361028, '资溪县', 361000, 1);
INSERT INTO `codeworld_area` VALUES (361029, '东乡县', 361000, 1);
INSERT INTO `codeworld_area` VALUES (361030, '广昌县', 361000, 1);
INSERT INTO `codeworld_area` VALUES (361100, '上饶市', 360000, 1);
INSERT INTO `codeworld_area` VALUES (361101, '市辖区', 361100, 1);
INSERT INTO `codeworld_area` VALUES (361102, '信州区', 361101, 1);
INSERT INTO `codeworld_area` VALUES (361121, '上饶县', 361100, 1);
INSERT INTO `codeworld_area` VALUES (361122, '广丰县', 361100, 1);
INSERT INTO `codeworld_area` VALUES (361123, '玉山县', 361100, 1);
INSERT INTO `codeworld_area` VALUES (361124, '铅山县', 361100, 1);
INSERT INTO `codeworld_area` VALUES (361125, '横峰县', 361100, 1);
INSERT INTO `codeworld_area` VALUES (361126, '弋阳县', 361100, 1);
INSERT INTO `codeworld_area` VALUES (361127, '余干县', 361100, 1);
INSERT INTO `codeworld_area` VALUES (361128, '鄱阳县', 361100, 1);
INSERT INTO `codeworld_area` VALUES (361129, '万年县', 361100, 1);
INSERT INTO `codeworld_area` VALUES (361130, '婺源县', 361100, 1);
INSERT INTO `codeworld_area` VALUES (361181, '德兴市', 361100, 1);
INSERT INTO `codeworld_area` VALUES (370000, '山东省', 0, 1);
INSERT INTO `codeworld_area` VALUES (370100, '济南市', 370000, 1);
INSERT INTO `codeworld_area` VALUES (370101, '市辖区', 370100, 1);
INSERT INTO `codeworld_area` VALUES (370102, '历下区', 370101, 1);
INSERT INTO `codeworld_area` VALUES (370103, '市中区', 370101, 1);
INSERT INTO `codeworld_area` VALUES (370104, '槐荫区', 370101, 1);
INSERT INTO `codeworld_area` VALUES (370105, '天桥区', 370101, 1);
INSERT INTO `codeworld_area` VALUES (370112, '历城区', 370101, 1);
INSERT INTO `codeworld_area` VALUES (370113, '长清区', 370101, 1);
INSERT INTO `codeworld_area` VALUES (370124, '平阴县', 370100, 1);
INSERT INTO `codeworld_area` VALUES (370125, '济阳县', 370100, 1);
INSERT INTO `codeworld_area` VALUES (370126, '商河县', 370100, 1);
INSERT INTO `codeworld_area` VALUES (370181, '章丘市', 370100, 1);
INSERT INTO `codeworld_area` VALUES (370200, '青岛市', 370000, 1);
INSERT INTO `codeworld_area` VALUES (370201, '市辖区', 370200, 1);
INSERT INTO `codeworld_area` VALUES (370202, '市南区', 370201, 1);
INSERT INTO `codeworld_area` VALUES (370203, '市北区', 370201, 1);
INSERT INTO `codeworld_area` VALUES (370205, '四方区', 370201, 1);
INSERT INTO `codeworld_area` VALUES (370211, '黄岛区', 370201, 1);
INSERT INTO `codeworld_area` VALUES (370212, '崂山区', 370201, 1);
INSERT INTO `codeworld_area` VALUES (370213, '李沧区', 370201, 1);
INSERT INTO `codeworld_area` VALUES (370214, '城阳区', 370201, 1);
INSERT INTO `codeworld_area` VALUES (370281, '胶州市', 370200, 1);
INSERT INTO `codeworld_area` VALUES (370282, '即墨市', 370200, 1);
INSERT INTO `codeworld_area` VALUES (370283, '平度市', 370200, 1);
INSERT INTO `codeworld_area` VALUES (370284, '胶南市', 370200, 1);
INSERT INTO `codeworld_area` VALUES (370285, '莱西市', 370200, 1);
INSERT INTO `codeworld_area` VALUES (370300, '淄博市', 370000, 1);
INSERT INTO `codeworld_area` VALUES (370301, '市辖区', 370300, 1);
INSERT INTO `codeworld_area` VALUES (370302, '淄川区', 370301, 1);
INSERT INTO `codeworld_area` VALUES (370303, '张店区', 370301, 1);
INSERT INTO `codeworld_area` VALUES (370304, '博山区', 370301, 1);
INSERT INTO `codeworld_area` VALUES (370305, '临淄区', 370301, 1);
INSERT INTO `codeworld_area` VALUES (370306, '周村区', 370301, 1);
INSERT INTO `codeworld_area` VALUES (370321, '桓台县', 370300, 1);
INSERT INTO `codeworld_area` VALUES (370322, '高青县', 370300, 1);
INSERT INTO `codeworld_area` VALUES (370323, '沂源县', 370300, 1);
INSERT INTO `codeworld_area` VALUES (370400, '枣庄市', 370000, 1);
INSERT INTO `codeworld_area` VALUES (370401, '市辖区', 370400, 1);
INSERT INTO `codeworld_area` VALUES (370402, '市中区', 370401, 1);
INSERT INTO `codeworld_area` VALUES (370403, '薛城区', 370401, 1);
INSERT INTO `codeworld_area` VALUES (370404, '峄城区', 370401, 1);
INSERT INTO `codeworld_area` VALUES (370405, '台儿庄区', 370401, 1);
INSERT INTO `codeworld_area` VALUES (370406, '山亭区', 370401, 1);
INSERT INTO `codeworld_area` VALUES (370481, '滕州市', 370400, 1);
INSERT INTO `codeworld_area` VALUES (370500, '东营市', 370000, 1);
INSERT INTO `codeworld_area` VALUES (370501, '市辖区', 370500, 1);
INSERT INTO `codeworld_area` VALUES (370502, '东营区', 370501, 1);
INSERT INTO `codeworld_area` VALUES (370503, '河口区', 370501, 1);
INSERT INTO `codeworld_area` VALUES (370521, '垦利县', 370500, 1);
INSERT INTO `codeworld_area` VALUES (370522, '利津县', 370500, 1);
INSERT INTO `codeworld_area` VALUES (370523, '广饶县', 370500, 1);
INSERT INTO `codeworld_area` VALUES (370600, '烟台市', 370000, 1);
INSERT INTO `codeworld_area` VALUES (370601, '市辖区', 370600, 1);
INSERT INTO `codeworld_area` VALUES (370602, '芝罘区', 370601, 1);
INSERT INTO `codeworld_area` VALUES (370611, '福山区', 370601, 1);
INSERT INTO `codeworld_area` VALUES (370612, '牟平区', 370601, 1);
INSERT INTO `codeworld_area` VALUES (370613, '莱山区', 370601, 1);
INSERT INTO `codeworld_area` VALUES (370634, '长岛县', 370600, 1);
INSERT INTO `codeworld_area` VALUES (370681, '龙口市', 370600, 1);
INSERT INTO `codeworld_area` VALUES (370682, '莱阳市', 370600, 1);
INSERT INTO `codeworld_area` VALUES (370683, '莱州市', 370600, 1);
INSERT INTO `codeworld_area` VALUES (370684, '蓬莱市', 370600, 1);
INSERT INTO `codeworld_area` VALUES (370685, '招远市', 370600, 1);
INSERT INTO `codeworld_area` VALUES (370686, '栖霞市', 370600, 1);
INSERT INTO `codeworld_area` VALUES (370687, '海阳市', 370600, 1);
INSERT INTO `codeworld_area` VALUES (370700, '潍坊市', 370000, 1);
INSERT INTO `codeworld_area` VALUES (370701, '市辖区', 370700, 1);
INSERT INTO `codeworld_area` VALUES (370702, '潍城区', 370701, 1);
INSERT INTO `codeworld_area` VALUES (370703, '寒亭区', 370701, 1);
INSERT INTO `codeworld_area` VALUES (370704, '坊子区', 370701, 1);
INSERT INTO `codeworld_area` VALUES (370705, '奎文区', 370701, 1);
INSERT INTO `codeworld_area` VALUES (370724, '临朐县', 370700, 1);
INSERT INTO `codeworld_area` VALUES (370725, '昌乐县', 370700, 1);
INSERT INTO `codeworld_area` VALUES (370781, '青州市', 370700, 1);
INSERT INTO `codeworld_area` VALUES (370782, '诸城市', 370700, 1);
INSERT INTO `codeworld_area` VALUES (370783, '寿光市', 370700, 1);
INSERT INTO `codeworld_area` VALUES (370784, '安丘市', 370700, 1);
INSERT INTO `codeworld_area` VALUES (370785, '高密市', 370700, 1);
INSERT INTO `codeworld_area` VALUES (370786, '昌邑市', 370700, 1);
INSERT INTO `codeworld_area` VALUES (370800, '济宁市', 370000, 1);
INSERT INTO `codeworld_area` VALUES (370801, '市辖区', 370800, 1);
INSERT INTO `codeworld_area` VALUES (370802, '市中区', 370801, 1);
INSERT INTO `codeworld_area` VALUES (370811, '任城区', 370801, 1);
INSERT INTO `codeworld_area` VALUES (370826, '微山县', 370800, 1);
INSERT INTO `codeworld_area` VALUES (370827, '鱼台县', 370800, 1);
INSERT INTO `codeworld_area` VALUES (370828, '金乡县', 370800, 1);
INSERT INTO `codeworld_area` VALUES (370829, '嘉祥县', 370800, 1);
INSERT INTO `codeworld_area` VALUES (370830, '汶上县', 370800, 1);
INSERT INTO `codeworld_area` VALUES (370831, '泗水县', 370800, 1);
INSERT INTO `codeworld_area` VALUES (370832, '梁山县', 370800, 1);
INSERT INTO `codeworld_area` VALUES (370881, '曲阜市', 370800, 1);
INSERT INTO `codeworld_area` VALUES (370882, '兖州市', 370800, 1);
INSERT INTO `codeworld_area` VALUES (370883, '邹城市', 370800, 1);
INSERT INTO `codeworld_area` VALUES (370900, '泰安市', 370000, 1);
INSERT INTO `codeworld_area` VALUES (370901, '岱岳区', 370900, 1);
INSERT INTO `codeworld_area` VALUES (370902, '泰山区', 370900, 1);
INSERT INTO `codeworld_area` VALUES (370921, '宁阳县', 370900, 1);
INSERT INTO `codeworld_area` VALUES (370923, '东平县', 370900, 1);
INSERT INTO `codeworld_area` VALUES (370982, '新泰市', 370900, 1);
INSERT INTO `codeworld_area` VALUES (370983, '肥城市', 370900, 1);
INSERT INTO `codeworld_area` VALUES (371000, '威海市', 370000, 1);
INSERT INTO `codeworld_area` VALUES (371001, '市辖区', 371000, 1);
INSERT INTO `codeworld_area` VALUES (371002, '环翠区', 371001, 1);
INSERT INTO `codeworld_area` VALUES (371081, '文登市', 371000, 1);
INSERT INTO `codeworld_area` VALUES (371082, '荣成市', 371000, 1);
INSERT INTO `codeworld_area` VALUES (371083, '乳山市', 371000, 1);
INSERT INTO `codeworld_area` VALUES (371100, '日照市', 370000, 1);
INSERT INTO `codeworld_area` VALUES (371101, '市辖区', 371100, 1);
INSERT INTO `codeworld_area` VALUES (371102, '东港区', 371101, 1);
INSERT INTO `codeworld_area` VALUES (371103, '岚山区', 371101, 1);
INSERT INTO `codeworld_area` VALUES (371121, '五莲县', 371100, 1);
INSERT INTO `codeworld_area` VALUES (371122, '莒县', 371100, 1);
INSERT INTO `codeworld_area` VALUES (371200, '莱芜市', 370000, 1);
INSERT INTO `codeworld_area` VALUES (371201, '市辖区', 371200, 1);
INSERT INTO `codeworld_area` VALUES (371202, '莱城区', 371201, 1);
INSERT INTO `codeworld_area` VALUES (371203, '钢城区', 371201, 1);
INSERT INTO `codeworld_area` VALUES (371300, '临沂市', 370000, 1);
INSERT INTO `codeworld_area` VALUES (371301, '市辖区', 371300, 1);
INSERT INTO `codeworld_area` VALUES (371302, '兰山区', 371301, 1);
INSERT INTO `codeworld_area` VALUES (371311, '罗庄区', 371301, 1);
INSERT INTO `codeworld_area` VALUES (371312, '河东区', 371301, 1);
INSERT INTO `codeworld_area` VALUES (371321, '沂南县', 371300, 1);
INSERT INTO `codeworld_area` VALUES (371322, '郯城县', 371300, 1);
INSERT INTO `codeworld_area` VALUES (371323, '沂水县', 371300, 1);
INSERT INTO `codeworld_area` VALUES (371324, '苍山县', 371300, 1);
INSERT INTO `codeworld_area` VALUES (371325, '费县', 371300, 1);
INSERT INTO `codeworld_area` VALUES (371326, '平邑县', 371300, 1);
INSERT INTO `codeworld_area` VALUES (371327, '莒南县', 371300, 1);
INSERT INTO `codeworld_area` VALUES (371328, '蒙阴县', 371300, 1);
INSERT INTO `codeworld_area` VALUES (371329, '临沭县', 371300, 1);
INSERT INTO `codeworld_area` VALUES (371400, '德州市', 370000, 1);
INSERT INTO `codeworld_area` VALUES (371401, '市辖区', 371400, 1);
INSERT INTO `codeworld_area` VALUES (371402, '德城区', 371401, 1);
INSERT INTO `codeworld_area` VALUES (371421, '陵县', 371400, 1);
INSERT INTO `codeworld_area` VALUES (371422, '宁津县', 371400, 1);
INSERT INTO `codeworld_area` VALUES (371423, '庆云县', 371400, 1);
INSERT INTO `codeworld_area` VALUES (371424, '临邑县', 371400, 1);
INSERT INTO `codeworld_area` VALUES (371425, '齐河县', 371400, 1);
INSERT INTO `codeworld_area` VALUES (371426, '平原县', 371400, 1);
INSERT INTO `codeworld_area` VALUES (371427, '夏津县', 371400, 1);
INSERT INTO `codeworld_area` VALUES (371428, '武城县', 371400, 1);
INSERT INTO `codeworld_area` VALUES (371481, '乐陵市', 371400, 1);
INSERT INTO `codeworld_area` VALUES (371482, '禹城市', 371400, 1);
INSERT INTO `codeworld_area` VALUES (371500, '聊城市', 370000, 1);
INSERT INTO `codeworld_area` VALUES (371501, '市辖区', 371500, 1);
INSERT INTO `codeworld_area` VALUES (371502, '东昌府区', 371501, 1);
INSERT INTO `codeworld_area` VALUES (371521, '阳谷县', 371500, 1);
INSERT INTO `codeworld_area` VALUES (371522, '莘县', 371500, 1);
INSERT INTO `codeworld_area` VALUES (371523, '茌平县', 371500, 1);
INSERT INTO `codeworld_area` VALUES (371524, '东阿县', 371500, 1);
INSERT INTO `codeworld_area` VALUES (371525, '冠县', 371500, 1);
INSERT INTO `codeworld_area` VALUES (371526, '高唐县', 371500, 1);
INSERT INTO `codeworld_area` VALUES (371581, '临清市', 371500, 1);
INSERT INTO `codeworld_area` VALUES (371600, '滨州市', 370000, 1);
INSERT INTO `codeworld_area` VALUES (371601, '市辖区', 371600, 1);
INSERT INTO `codeworld_area` VALUES (371602, '滨城区', 371601, 1);
INSERT INTO `codeworld_area` VALUES (371621, '惠民县', 371600, 1);
INSERT INTO `codeworld_area` VALUES (371622, '阳信县', 371600, 1);
INSERT INTO `codeworld_area` VALUES (371623, '无棣县', 371600, 1);
INSERT INTO `codeworld_area` VALUES (371624, '沾化县', 371600, 1);
INSERT INTO `codeworld_area` VALUES (371625, '博兴县', 371600, 1);
INSERT INTO `codeworld_area` VALUES (371626, '邹平县', 371600, 1);
INSERT INTO `codeworld_area` VALUES (371700, '菏泽市', 370000, 1);
INSERT INTO `codeworld_area` VALUES (371701, '市辖区', 371700, 1);
INSERT INTO `codeworld_area` VALUES (371702, '牡丹区', 371701, 1);
INSERT INTO `codeworld_area` VALUES (371721, '曹县', 371700, 1);
INSERT INTO `codeworld_area` VALUES (371722, '单县', 371700, 1);
INSERT INTO `codeworld_area` VALUES (371723, '成武县', 371700, 1);
INSERT INTO `codeworld_area` VALUES (371724, '巨野县', 371700, 1);
INSERT INTO `codeworld_area` VALUES (371725, '郓城县', 371700, 1);
INSERT INTO `codeworld_area` VALUES (371726, '鄄城县', 371700, 1);
INSERT INTO `codeworld_area` VALUES (371727, '定陶县', 371700, 1);
INSERT INTO `codeworld_area` VALUES (371728, '东明县', 371700, 1);
INSERT INTO `codeworld_area` VALUES (410000, '河南省', 0, 1);
INSERT INTO `codeworld_area` VALUES (410100, '郑州市', 410000, 1);
INSERT INTO `codeworld_area` VALUES (410101, '金水区', 410100, 1);
INSERT INTO `codeworld_area` VALUES (410102, '中原区', 410100, 1);
INSERT INTO `codeworld_area` VALUES (410103, '二七区', 410100, 1);
INSERT INTO `codeworld_area` VALUES (410104, '管城回族区', 410100, 1);
INSERT INTO `codeworld_area` VALUES (410106, '上街区', 410100, 1);
INSERT INTO `codeworld_area` VALUES (410108, '惠济区', 410100, 1);
INSERT INTO `codeworld_area` VALUES (410122, '中牟县', 410100, 1);
INSERT INTO `codeworld_area` VALUES (410181, '巩义市', 410100, 1);
INSERT INTO `codeworld_area` VALUES (410182, '荥阳市', 410100, 1);
INSERT INTO `codeworld_area` VALUES (410183, '新密市', 410100, 1);
INSERT INTO `codeworld_area` VALUES (410184, '新郑市', 410100, 1);
INSERT INTO `codeworld_area` VALUES (410185, '登封市', 410100, 1);
INSERT INTO `codeworld_area` VALUES (410200, '开封市', 410000, 1);
INSERT INTO `codeworld_area` VALUES (410201, '市辖区', 410200, 1);
INSERT INTO `codeworld_area` VALUES (410202, '龙亭区', 410201, 1);
INSERT INTO `codeworld_area` VALUES (410203, '顺河回族区', 410201, 1);
INSERT INTO `codeworld_area` VALUES (410204, '鼓楼区', 410201, 1);
INSERT INTO `codeworld_area` VALUES (410205, '禹王台区', 410201, 1);
INSERT INTO `codeworld_area` VALUES (410211, '金明区', 410201, 1);
INSERT INTO `codeworld_area` VALUES (410221, '杞县', 410200, 1);
INSERT INTO `codeworld_area` VALUES (410222, '通许县', 410200, 1);
INSERT INTO `codeworld_area` VALUES (410223, '尉氏县', 410200, 1);
INSERT INTO `codeworld_area` VALUES (410224, '开封县', 410200, 1);
INSERT INTO `codeworld_area` VALUES (410225, '兰考县', 410200, 1);
INSERT INTO `codeworld_area` VALUES (410300, '洛阳市', 410000, 1);
INSERT INTO `codeworld_area` VALUES (410301, '市辖区', 410300, 1);
INSERT INTO `codeworld_area` VALUES (410302, '老城区', 410301, 1);
INSERT INTO `codeworld_area` VALUES (410303, '西工区', 410301, 1);
INSERT INTO `codeworld_area` VALUES (410304, '廛河回族区', 410301, 1);
INSERT INTO `codeworld_area` VALUES (410305, '涧西区', 410301, 1);
INSERT INTO `codeworld_area` VALUES (410306, '吉利区', 410301, 1);
INSERT INTO `codeworld_area` VALUES (410307, '洛龙区', 410301, 1);
INSERT INTO `codeworld_area` VALUES (410322, '孟津县', 410300, 1);
INSERT INTO `codeworld_area` VALUES (410323, '新安县', 410300, 1);
INSERT INTO `codeworld_area` VALUES (410324, '栾川县', 410300, 1);
INSERT INTO `codeworld_area` VALUES (410325, '嵩县', 410300, 1);
INSERT INTO `codeworld_area` VALUES (410326, '汝阳县', 410300, 1);
INSERT INTO `codeworld_area` VALUES (410327, '宜阳县', 410300, 1);
INSERT INTO `codeworld_area` VALUES (410328, '洛宁县', 410300, 1);
INSERT INTO `codeworld_area` VALUES (410329, '伊川县', 410300, 1);
INSERT INTO `codeworld_area` VALUES (410381, '偃师市', 410300, 1);
INSERT INTO `codeworld_area` VALUES (410400, '平顶山市', 410000, 1);
INSERT INTO `codeworld_area` VALUES (410401, '市辖区', 410400, 1);
INSERT INTO `codeworld_area` VALUES (410402, '新华区', 410401, 1);
INSERT INTO `codeworld_area` VALUES (410403, '卫东区', 410401, 1);
INSERT INTO `codeworld_area` VALUES (410404, '石龙区', 410401, 1);
INSERT INTO `codeworld_area` VALUES (410411, '湛河区', 410401, 1);
INSERT INTO `codeworld_area` VALUES (410421, '宝丰县', 410400, 1);
INSERT INTO `codeworld_area` VALUES (410422, '叶县', 410400, 1);
INSERT INTO `codeworld_area` VALUES (410423, '鲁山县', 410400, 1);
INSERT INTO `codeworld_area` VALUES (410425, '郏县', 410400, 1);
INSERT INTO `codeworld_area` VALUES (410481, '舞钢市', 410400, 1);
INSERT INTO `codeworld_area` VALUES (410482, '汝州市', 410400, 1);
INSERT INTO `codeworld_area` VALUES (410500, '安阳市', 410000, 1);
INSERT INTO `codeworld_area` VALUES (410501, '市辖区', 410500, 1);
INSERT INTO `codeworld_area` VALUES (410502, '文峰区', 410501, 1);
INSERT INTO `codeworld_area` VALUES (410503, '北关区', 410501, 1);
INSERT INTO `codeworld_area` VALUES (410505, '殷都区', 410501, 1);
INSERT INTO `codeworld_area` VALUES (410506, '龙安区', 410501, 1);
INSERT INTO `codeworld_area` VALUES (410522, '安阳县', 410500, 1);
INSERT INTO `codeworld_area` VALUES (410523, '汤阴县', 410500, 1);
INSERT INTO `codeworld_area` VALUES (410526, '滑县', 410500, 1);
INSERT INTO `codeworld_area` VALUES (410527, '内黄县', 410500, 1);
INSERT INTO `codeworld_area` VALUES (410581, '林州市', 410500, 1);
INSERT INTO `codeworld_area` VALUES (410600, '鹤壁市', 410000, 1);
INSERT INTO `codeworld_area` VALUES (410601, '市辖区', 410600, 1);
INSERT INTO `codeworld_area` VALUES (410602, '鹤山区', 410601, 1);
INSERT INTO `codeworld_area` VALUES (410603, '山城区', 410601, 1);
INSERT INTO `codeworld_area` VALUES (410611, '淇滨区', 410601, 1);
INSERT INTO `codeworld_area` VALUES (410621, '浚县', 410600, 1);
INSERT INTO `codeworld_area` VALUES (410622, '淇县', 410600, 1);
INSERT INTO `codeworld_area` VALUES (410700, '新乡市', 410000, 1);
INSERT INTO `codeworld_area` VALUES (410701, '市辖区', 410700, 1);
INSERT INTO `codeworld_area` VALUES (410702, '红旗区', 410700, 1);
INSERT INTO `codeworld_area` VALUES (410703, '卫滨区', 410700, 1);
INSERT INTO `codeworld_area` VALUES (410704, '凤泉区', 410700, 1);
INSERT INTO `codeworld_area` VALUES (410711, '牧野区', 410700, 1);
INSERT INTO `codeworld_area` VALUES (410721, '新乡县', 410700, 1);
INSERT INTO `codeworld_area` VALUES (410724, '获嘉县', 410700, 1);
INSERT INTO `codeworld_area` VALUES (410725, '原阳县', 410700, 1);
INSERT INTO `codeworld_area` VALUES (410726, '延津县', 410700, 1);
INSERT INTO `codeworld_area` VALUES (410727, '封丘县', 410700, 1);
INSERT INTO `codeworld_area` VALUES (410728, '长垣县', 410700, 1);
INSERT INTO `codeworld_area` VALUES (410781, '卫辉市', 410700, 1);
INSERT INTO `codeworld_area` VALUES (410782, '辉县市', 410700, 1);
INSERT INTO `codeworld_area` VALUES (410800, '焦作市', 410000, 1);
INSERT INTO `codeworld_area` VALUES (410801, '市辖区', 410800, 1);
INSERT INTO `codeworld_area` VALUES (410802, '解放区', 410801, 1);
INSERT INTO `codeworld_area` VALUES (410803, '中站区', 410801, 1);
INSERT INTO `codeworld_area` VALUES (410804, '马村区', 410801, 1);
INSERT INTO `codeworld_area` VALUES (410811, '山阳区', 410801, 1);
INSERT INTO `codeworld_area` VALUES (410821, '修武县', 410800, 1);
INSERT INTO `codeworld_area` VALUES (410822, '博爱县', 410800, 1);
INSERT INTO `codeworld_area` VALUES (410823, '武陟县', 410800, 1);
INSERT INTO `codeworld_area` VALUES (410825, '温县', 410800, 1);
INSERT INTO `codeworld_area` VALUES (410882, '沁阳市', 410800, 1);
INSERT INTO `codeworld_area` VALUES (410883, '孟州市', 410800, 1);
INSERT INTO `codeworld_area` VALUES (410900, '濮阳市', 410000, 1);
INSERT INTO `codeworld_area` VALUES (410901, '市辖区', 410900, 1);
INSERT INTO `codeworld_area` VALUES (410902, '华龙区', 410901, 1);
INSERT INTO `codeworld_area` VALUES (410922, '清丰县', 410900, 1);
INSERT INTO `codeworld_area` VALUES (410923, '南乐县', 410900, 1);
INSERT INTO `codeworld_area` VALUES (410926, '范县', 410900, 1);
INSERT INTO `codeworld_area` VALUES (410927, '台前县', 410900, 1);
INSERT INTO `codeworld_area` VALUES (410928, '濮阳县', 410900, 1);
INSERT INTO `codeworld_area` VALUES (411000, '许昌市', 410000, 1);
INSERT INTO `codeworld_area` VALUES (411001, '市辖区', 411000, 1);
INSERT INTO `codeworld_area` VALUES (411002, '魏都区', 411001, 1);
INSERT INTO `codeworld_area` VALUES (411023, '许昌县', 411000, 1);
INSERT INTO `codeworld_area` VALUES (411024, '鄢陵县', 411000, 1);
INSERT INTO `codeworld_area` VALUES (411025, '襄城县', 411000, 1);
INSERT INTO `codeworld_area` VALUES (411081, '禹州市', 411000, 1);
INSERT INTO `codeworld_area` VALUES (411082, '长葛市', 411000, 1);
INSERT INTO `codeworld_area` VALUES (411100, '漯河市', 410000, 1);
INSERT INTO `codeworld_area` VALUES (411101, '召陵区', 411100, 1);
INSERT INTO `codeworld_area` VALUES (411102, '源汇区', 411100, 1);
INSERT INTO `codeworld_area` VALUES (411103, '郾城区', 411100, 1);
INSERT INTO `codeworld_area` VALUES (411121, '舞阳县', 411100, 1);
INSERT INTO `codeworld_area` VALUES (411122, '临颍县', 411100, 1);
INSERT INTO `codeworld_area` VALUES (411200, '三门峡市', 410000, 1);
INSERT INTO `codeworld_area` VALUES (411201, '市辖区', 411200, 1);
INSERT INTO `codeworld_area` VALUES (411202, '湖滨区', 411201, 1);
INSERT INTO `codeworld_area` VALUES (411221, '渑池县', 411200, 1);
INSERT INTO `codeworld_area` VALUES (411222, '陕县', 411200, 1);
INSERT INTO `codeworld_area` VALUES (411224, '卢氏县', 411200, 1);
INSERT INTO `codeworld_area` VALUES (411281, '义马市', 411200, 1);
INSERT INTO `codeworld_area` VALUES (411282, '灵宝市', 411200, 1);
INSERT INTO `codeworld_area` VALUES (411300, '南阳市', 410000, 1);
INSERT INTO `codeworld_area` VALUES (411301, '市辖区', 411300, 1);
INSERT INTO `codeworld_area` VALUES (411302, '宛城区', 411301, 1);
INSERT INTO `codeworld_area` VALUES (411303, '卧龙区', 411301, 1);
INSERT INTO `codeworld_area` VALUES (411321, '南召县', 411300, 1);
INSERT INTO `codeworld_area` VALUES (411322, '方城县', 411300, 1);
INSERT INTO `codeworld_area` VALUES (411323, '西峡县', 411300, 1);
INSERT INTO `codeworld_area` VALUES (411324, '镇平县', 411300, 1);
INSERT INTO `codeworld_area` VALUES (411325, '内乡县', 411300, 1);
INSERT INTO `codeworld_area` VALUES (411326, '淅川县', 411300, 1);
INSERT INTO `codeworld_area` VALUES (411327, '社旗县', 411300, 1);
INSERT INTO `codeworld_area` VALUES (411328, '唐河县', 411300, 1);
INSERT INTO `codeworld_area` VALUES (411329, '新野县', 411300, 1);
INSERT INTO `codeworld_area` VALUES (411330, '桐柏县', 411300, 1);
INSERT INTO `codeworld_area` VALUES (411381, '邓州市', 411300, 1);
INSERT INTO `codeworld_area` VALUES (411400, '商丘市', 410000, 1);
INSERT INTO `codeworld_area` VALUES (411401, '市辖区', 411400, 1);
INSERT INTO `codeworld_area` VALUES (411402, '梁园区', 411400, 1);
INSERT INTO `codeworld_area` VALUES (411403, '睢阳区', 411400, 1);
INSERT INTO `codeworld_area` VALUES (411421, '民权县', 411400, 1);
INSERT INTO `codeworld_area` VALUES (411422, '睢县', 411400, 1);
INSERT INTO `codeworld_area` VALUES (411423, '宁陵县', 411400, 1);
INSERT INTO `codeworld_area` VALUES (411424, '柘城县', 411400, 1);
INSERT INTO `codeworld_area` VALUES (411425, '虞城县', 411400, 1);
INSERT INTO `codeworld_area` VALUES (411426, '夏邑县', 411400, 1);
INSERT INTO `codeworld_area` VALUES (411481, '永城市', 411400, 1);
INSERT INTO `codeworld_area` VALUES (411482, '新区', 411400, 1);
INSERT INTO `codeworld_area` VALUES (411500, '信阳市', 410000, 1);
INSERT INTO `codeworld_area` VALUES (411501, '市辖区', 411500, 1);
INSERT INTO `codeworld_area` VALUES (411502, '浉河区', 411501, 1);
INSERT INTO `codeworld_area` VALUES (411503, '平桥区', 411501, 1);
INSERT INTO `codeworld_area` VALUES (411521, '罗山县', 411500, 1);
INSERT INTO `codeworld_area` VALUES (411522, '光山县', 411500, 1);
INSERT INTO `codeworld_area` VALUES (411523, '新县', 411500, 1);
INSERT INTO `codeworld_area` VALUES (411524, '商城县', 411500, 1);
INSERT INTO `codeworld_area` VALUES (411525, '固始县', 411500, 1);
INSERT INTO `codeworld_area` VALUES (411526, '潢川县', 411500, 1);
INSERT INTO `codeworld_area` VALUES (411527, '淮滨县', 411500, 1);
INSERT INTO `codeworld_area` VALUES (411528, '息县', 411500, 1);
INSERT INTO `codeworld_area` VALUES (411600, '周口市', 410000, 1);
INSERT INTO `codeworld_area` VALUES (411601, '市辖区', 411600, 1);
INSERT INTO `codeworld_area` VALUES (411602, '川汇区', 411601, 1);
INSERT INTO `codeworld_area` VALUES (411621, '扶沟县', 411600, 1);
INSERT INTO `codeworld_area` VALUES (411622, '西华县', 411600, 1);
INSERT INTO `codeworld_area` VALUES (411623, '商水县', 411600, 1);
INSERT INTO `codeworld_area` VALUES (411624, '沈丘县', 411600, 1);
INSERT INTO `codeworld_area` VALUES (411625, '郸城县', 411600, 1);
INSERT INTO `codeworld_area` VALUES (411626, '淮阳县', 411600, 1);
INSERT INTO `codeworld_area` VALUES (411627, '太康县', 411600, 1);
INSERT INTO `codeworld_area` VALUES (411628, '鹿邑县', 411600, 1);
INSERT INTO `codeworld_area` VALUES (411681, '项城市', 411600, 1);
INSERT INTO `codeworld_area` VALUES (411700, '驻马店市', 410000, 1);
INSERT INTO `codeworld_area` VALUES (411701, '市辖区', 411700, 1);
INSERT INTO `codeworld_area` VALUES (411702, '驿城区', 411701, 1);
INSERT INTO `codeworld_area` VALUES (411721, '西平县', 411700, 1);
INSERT INTO `codeworld_area` VALUES (411722, '上蔡县', 411700, 1);
INSERT INTO `codeworld_area` VALUES (411723, '平舆县', 411700, 1);
INSERT INTO `codeworld_area` VALUES (411724, '正阳县', 411700, 1);
INSERT INTO `codeworld_area` VALUES (411725, '确山县', 411700, 1);
INSERT INTO `codeworld_area` VALUES (411726, '泌阳县', 411700, 1);
INSERT INTO `codeworld_area` VALUES (411727, '汝南县', 411700, 1);
INSERT INTO `codeworld_area` VALUES (411728, '遂平县', 411700, 1);
INSERT INTO `codeworld_area` VALUES (411729, '新蔡县', 411700, 1);
INSERT INTO `codeworld_area` VALUES (411800, '济源市', 410000, 1);
INSERT INTO `codeworld_area` VALUES (411801, '市辖区', 411800, 1);
INSERT INTO `codeworld_area` VALUES (420000, '湖北省', 0, 1);
INSERT INTO `codeworld_area` VALUES (420100, '武汉市', 420000, 1);
INSERT INTO `codeworld_area` VALUES (420101, '市辖区', 420100, 1);
INSERT INTO `codeworld_area` VALUES (420102, '江岸区', 420101, 1);
INSERT INTO `codeworld_area` VALUES (420103, '江汉区', 420101, 1);
INSERT INTO `codeworld_area` VALUES (420104, '硚口区', 420101, 1);
INSERT INTO `codeworld_area` VALUES (420105, '汉阳区', 420101, 1);
INSERT INTO `codeworld_area` VALUES (420106, '武昌区', 420101, 1);
INSERT INTO `codeworld_area` VALUES (420107, '青山区', 420101, 1);
INSERT INTO `codeworld_area` VALUES (420111, '洪山区', 420101, 1);
INSERT INTO `codeworld_area` VALUES (420112, '东西湖区', 420101, 1);
INSERT INTO `codeworld_area` VALUES (420113, '汉南区', 420101, 1);
INSERT INTO `codeworld_area` VALUES (420114, '蔡甸区', 420101, 1);
INSERT INTO `codeworld_area` VALUES (420115, '江夏区', 420101, 1);
INSERT INTO `codeworld_area` VALUES (420116, '黄陂区', 420101, 1);
INSERT INTO `codeworld_area` VALUES (420117, '新洲区', 420100, 1);
INSERT INTO `codeworld_area` VALUES (420200, '黄石市', 420000, 1);
INSERT INTO `codeworld_area` VALUES (420201, '市辖区', 420200, 1);
INSERT INTO `codeworld_area` VALUES (420202, '黄石港区', 420201, 1);
INSERT INTO `codeworld_area` VALUES (420203, '西塞山区', 420201, 1);
INSERT INTO `codeworld_area` VALUES (420204, '下陆区', 420201, 1);
INSERT INTO `codeworld_area` VALUES (420205, '铁山区', 420201, 1);
INSERT INTO `codeworld_area` VALUES (420222, '阳新县', 420200, 1);
INSERT INTO `codeworld_area` VALUES (420281, '大冶市', 420200, 1);
INSERT INTO `codeworld_area` VALUES (420300, '十堰市', 420000, 1);
INSERT INTO `codeworld_area` VALUES (420301, '市辖区', 420300, 1);
INSERT INTO `codeworld_area` VALUES (420302, '茅箭区', 420301, 1);
INSERT INTO `codeworld_area` VALUES (420303, '张湾区', 420301, 1);
INSERT INTO `codeworld_area` VALUES (420321, '郧县', 420300, 1);
INSERT INTO `codeworld_area` VALUES (420322, '郧西县', 420300, 1);
INSERT INTO `codeworld_area` VALUES (420323, '竹山县', 420300, 1);
INSERT INTO `codeworld_area` VALUES (420324, '竹溪县', 420300, 1);
INSERT INTO `codeworld_area` VALUES (420325, '房县', 420300, 1);
INSERT INTO `codeworld_area` VALUES (420381, '丹江口市', 420300, 1);
INSERT INTO `codeworld_area` VALUES (420500, '宜昌市', 420000, 1);
INSERT INTO `codeworld_area` VALUES (420501, '市辖区', 420500, 1);
INSERT INTO `codeworld_area` VALUES (420502, '西陵区', 420501, 1);
INSERT INTO `codeworld_area` VALUES (420503, '伍家岗区', 420501, 1);
INSERT INTO `codeworld_area` VALUES (420504, '点军区', 420501, 1);
INSERT INTO `codeworld_area` VALUES (420505, '猇亭区', 420501, 1);
INSERT INTO `codeworld_area` VALUES (420506, '夷陵区', 420501, 1);
INSERT INTO `codeworld_area` VALUES (420525, '远安县', 420500, 1);
INSERT INTO `codeworld_area` VALUES (420526, '兴山县', 420500, 1);
INSERT INTO `codeworld_area` VALUES (420527, '秭归县', 420500, 1);
INSERT INTO `codeworld_area` VALUES (420528, '长阳土家族自治县', 420500, 1);
INSERT INTO `codeworld_area` VALUES (420529, '五峰土家族自治县', 420500, 1);
INSERT INTO `codeworld_area` VALUES (420581, '宜都市', 420500, 1);
INSERT INTO `codeworld_area` VALUES (420582, '当阳市', 420500, 1);
INSERT INTO `codeworld_area` VALUES (420583, '枝江市', 420500, 1);
INSERT INTO `codeworld_area` VALUES (420600, '襄阳市', 420000, 1);
INSERT INTO `codeworld_area` VALUES (420601, '市辖区', 420600, 1);
INSERT INTO `codeworld_area` VALUES (420602, '襄城区', 420601, 1);
INSERT INTO `codeworld_area` VALUES (420606, '樊城区', 420601, 1);
INSERT INTO `codeworld_area` VALUES (420607, '襄州区', 420601, 1);
INSERT INTO `codeworld_area` VALUES (420624, '南漳县', 420600, 1);
INSERT INTO `codeworld_area` VALUES (420625, '谷城县', 420600, 1);
INSERT INTO `codeworld_area` VALUES (420626, '保康县', 420600, 1);
INSERT INTO `codeworld_area` VALUES (420682, '老河口市', 420600, 1);
INSERT INTO `codeworld_area` VALUES (420683, '枣阳市', 420600, 1);
INSERT INTO `codeworld_area` VALUES (420684, '宜城市', 420600, 1);
INSERT INTO `codeworld_area` VALUES (420700, '鄂州市', 420000, 1);
INSERT INTO `codeworld_area` VALUES (420701, '市辖区', 420700, 1);
INSERT INTO `codeworld_area` VALUES (420702, '梁子湖区', 420701, 1);
INSERT INTO `codeworld_area` VALUES (420703, '华容区', 420701, 1);
INSERT INTO `codeworld_area` VALUES (420704, '鄂城区', 420701, 1);
INSERT INTO `codeworld_area` VALUES (420800, '荆门市', 420000, 1);
INSERT INTO `codeworld_area` VALUES (420801, '市辖区', 420800, 1);
INSERT INTO `codeworld_area` VALUES (420802, '东宝区', 420801, 1);
INSERT INTO `codeworld_area` VALUES (420804, '掇刀区', 420801, 1);
INSERT INTO `codeworld_area` VALUES (420821, '京山县', 420800, 1);
INSERT INTO `codeworld_area` VALUES (420822, '沙洋县', 420800, 1);
INSERT INTO `codeworld_area` VALUES (420881, '钟祥市', 420800, 1);
INSERT INTO `codeworld_area` VALUES (420900, '孝感市', 420000, 1);
INSERT INTO `codeworld_area` VALUES (420901, '市辖区', 420900, 1);
INSERT INTO `codeworld_area` VALUES (420902, '孝南区', 420901, 1);
INSERT INTO `codeworld_area` VALUES (420921, '孝昌县', 420900, 1);
INSERT INTO `codeworld_area` VALUES (420922, '大悟县', 420900, 1);
INSERT INTO `codeworld_area` VALUES (420923, '云梦县', 420900, 1);
INSERT INTO `codeworld_area` VALUES (420981, '应城市', 420900, 1);
INSERT INTO `codeworld_area` VALUES (420982, '安陆市', 420900, 1);
INSERT INTO `codeworld_area` VALUES (420984, '汉川市', 420900, 1);
INSERT INTO `codeworld_area` VALUES (421000, '荆州市', 420000, 1);
INSERT INTO `codeworld_area` VALUES (421001, '市辖区', 421000, 1);
INSERT INTO `codeworld_area` VALUES (421002, '沙市区', 421001, 1);
INSERT INTO `codeworld_area` VALUES (421003, '荆州区', 421001, 1);
INSERT INTO `codeworld_area` VALUES (421022, '公安县', 421000, 1);
INSERT INTO `codeworld_area` VALUES (421023, '监利县', 421000, 1);
INSERT INTO `codeworld_area` VALUES (421024, '江陵县', 421000, 1);
INSERT INTO `codeworld_area` VALUES (421081, '石首市', 421000, 1);
INSERT INTO `codeworld_area` VALUES (421083, '洪湖市', 421000, 1);
INSERT INTO `codeworld_area` VALUES (421087, '松滋市', 421000, 1);
INSERT INTO `codeworld_area` VALUES (421100, '黄冈市', 420000, 1);
INSERT INTO `codeworld_area` VALUES (421101, '市辖区', 421100, 1);
INSERT INTO `codeworld_area` VALUES (421102, '黄州区', 421101, 1);
INSERT INTO `codeworld_area` VALUES (421121, '团风县', 421100, 1);
INSERT INTO `codeworld_area` VALUES (421122, '红安县', 421100, 1);
INSERT INTO `codeworld_area` VALUES (421123, '罗田县', 421100, 1);
INSERT INTO `codeworld_area` VALUES (421124, '英山县', 421100, 1);
INSERT INTO `codeworld_area` VALUES (421125, '浠水县', 421100, 1);
INSERT INTO `codeworld_area` VALUES (421126, '蕲春县', 421100, 1);
INSERT INTO `codeworld_area` VALUES (421127, '黄梅县', 421100, 1);
INSERT INTO `codeworld_area` VALUES (421181, '麻城市', 421100, 1);
INSERT INTO `codeworld_area` VALUES (421182, '武穴市', 421100, 1);
INSERT INTO `codeworld_area` VALUES (421200, '咸宁市', 420000, 1);
INSERT INTO `codeworld_area` VALUES (421201, '市辖区', 421200, 1);
INSERT INTO `codeworld_area` VALUES (421202, '咸安区', 421201, 1);
INSERT INTO `codeworld_area` VALUES (421221, '嘉鱼县', 421200, 1);
INSERT INTO `codeworld_area` VALUES (421222, '通城县', 421200, 1);
INSERT INTO `codeworld_area` VALUES (421223, '崇阳县', 421200, 1);
INSERT INTO `codeworld_area` VALUES (421224, '通山县', 421200, 1);
INSERT INTO `codeworld_area` VALUES (421281, '赤壁市', 421200, 1);
INSERT INTO `codeworld_area` VALUES (421300, '随州市', 420000, 1);
INSERT INTO `codeworld_area` VALUES (421301, '市辖区', 421300, 1);
INSERT INTO `codeworld_area` VALUES (421302, '曾都区', 421301, 1);
INSERT INTO `codeworld_area` VALUES (421381, '广水市', 421300, 1);
INSERT INTO `codeworld_area` VALUES (422800, '恩施土家族苗族自治州', 420000, 1);
INSERT INTO `codeworld_area` VALUES (422801, '恩施市', 422800, 1);
INSERT INTO `codeworld_area` VALUES (422802, '利川市', 422800, 1);
INSERT INTO `codeworld_area` VALUES (422822, '建始县', 422800, 1);
INSERT INTO `codeworld_area` VALUES (422823, '巴东县', 422800, 1);
INSERT INTO `codeworld_area` VALUES (422825, '宣恩县', 422800, 1);
INSERT INTO `codeworld_area` VALUES (422826, '咸丰县', 422800, 1);
INSERT INTO `codeworld_area` VALUES (422827, '来凤县', 422800, 1);
INSERT INTO `codeworld_area` VALUES (422828, '鹤峰县', 422800, 1);
INSERT INTO `codeworld_area` VALUES (429000, '省直辖行政单位', 420000, 1);
INSERT INTO `codeworld_area` VALUES (429004, '仙桃市', 429000, 1);
INSERT INTO `codeworld_area` VALUES (429005, '潜江市', 429000, 1);
INSERT INTO `codeworld_area` VALUES (429006, '天门市', 429000, 1);
INSERT INTO `codeworld_area` VALUES (429021, '神农架林区', 429000, 1);
INSERT INTO `codeworld_area` VALUES (430000, '湖南省', 0, 1);
INSERT INTO `codeworld_area` VALUES (430100, '长沙市', 430000, 1);
INSERT INTO `codeworld_area` VALUES (430101, '市辖区', 430100, 1);
INSERT INTO `codeworld_area` VALUES (430102, '芙蓉区', 430101, 1);
INSERT INTO `codeworld_area` VALUES (430103, '天心区', 430101, 1);
INSERT INTO `codeworld_area` VALUES (430104, '岳麓区', 430101, 1);
INSERT INTO `codeworld_area` VALUES (430105, '开福区', 430101, 1);
INSERT INTO `codeworld_area` VALUES (430111, '雨花区', 430101, 1);
INSERT INTO `codeworld_area` VALUES (430121, '长沙县', 430100, 1);
INSERT INTO `codeworld_area` VALUES (430122, '望城县', 430100, 1);
INSERT INTO `codeworld_area` VALUES (430124, '宁乡县', 430100, 1);
INSERT INTO `codeworld_area` VALUES (430181, '浏阳市', 430100, 1);
INSERT INTO `codeworld_area` VALUES (430200, '株洲市', 430000, 1);
INSERT INTO `codeworld_area` VALUES (430201, '市辖区', 430200, 1);
INSERT INTO `codeworld_area` VALUES (430202, '荷塘区', 430201, 1);
INSERT INTO `codeworld_area` VALUES (430203, '芦淞区', 430201, 1);
INSERT INTO `codeworld_area` VALUES (430204, '石峰区', 430201, 1);
INSERT INTO `codeworld_area` VALUES (430211, '天元区', 430201, 1);
INSERT INTO `codeworld_area` VALUES (430221, '株洲县', 430200, 1);
INSERT INTO `codeworld_area` VALUES (430223, '攸县', 430200, 1);
INSERT INTO `codeworld_area` VALUES (430224, '茶陵县', 430200, 1);
INSERT INTO `codeworld_area` VALUES (430225, '炎陵县', 430200, 1);
INSERT INTO `codeworld_area` VALUES (430281, '醴陵市', 430200, 1);
INSERT INTO `codeworld_area` VALUES (430300, '湘潭市', 430000, 1);
INSERT INTO `codeworld_area` VALUES (430301, '市辖区', 430300, 1);
INSERT INTO `codeworld_area` VALUES (430302, '雨湖区', 430301, 1);
INSERT INTO `codeworld_area` VALUES (430304, '岳塘区', 430301, 1);
INSERT INTO `codeworld_area` VALUES (430321, '湘潭县', 430300, 1);
INSERT INTO `codeworld_area` VALUES (430381, '湘乡市', 430300, 1);
INSERT INTO `codeworld_area` VALUES (430382, '韶山市', 430300, 1);
INSERT INTO `codeworld_area` VALUES (430400, '衡阳市', 430000, 1);
INSERT INTO `codeworld_area` VALUES (430401, '市辖区', 430400, 1);
INSERT INTO `codeworld_area` VALUES (430405, '珠晖区', 430401, 1);
INSERT INTO `codeworld_area` VALUES (430406, '雁峰区', 430401, 1);
INSERT INTO `codeworld_area` VALUES (430407, '石鼓区', 430401, 1);
INSERT INTO `codeworld_area` VALUES (430408, '蒸湘区', 430401, 1);
INSERT INTO `codeworld_area` VALUES (430412, '南岳区', 430401, 1);
INSERT INTO `codeworld_area` VALUES (430421, '衡阳县', 430400, 1);
INSERT INTO `codeworld_area` VALUES (430422, '衡南县', 430400, 1);
INSERT INTO `codeworld_area` VALUES (430423, '衡山县', 430400, 1);
INSERT INTO `codeworld_area` VALUES (430424, '衡东县', 430400, 1);
INSERT INTO `codeworld_area` VALUES (430426, '祁东县', 430400, 1);
INSERT INTO `codeworld_area` VALUES (430481, '耒阳市', 430400, 1);
INSERT INTO `codeworld_area` VALUES (430482, '常宁市', 430400, 1);
INSERT INTO `codeworld_area` VALUES (430500, '邵阳市', 430000, 1);
INSERT INTO `codeworld_area` VALUES (430501, '市辖区', 430500, 1);
INSERT INTO `codeworld_area` VALUES (430502, '双清区', 430501, 1);
INSERT INTO `codeworld_area` VALUES (430503, '大祥区', 430501, 1);
INSERT INTO `codeworld_area` VALUES (430511, '北塔区', 430501, 1);
INSERT INTO `codeworld_area` VALUES (430521, '邵东县', 430500, 1);
INSERT INTO `codeworld_area` VALUES (430522, '新邵县', 430500, 1);
INSERT INTO `codeworld_area` VALUES (430523, '邵阳县', 430500, 1);
INSERT INTO `codeworld_area` VALUES (430524, '隆回县', 430500, 1);
INSERT INTO `codeworld_area` VALUES (430525, '洞口县', 430500, 1);
INSERT INTO `codeworld_area` VALUES (430527, '绥宁县', 430500, 1);
INSERT INTO `codeworld_area` VALUES (430528, '新宁县', 430500, 1);
INSERT INTO `codeworld_area` VALUES (430529, '城步苗族自治县', 430500, 1);
INSERT INTO `codeworld_area` VALUES (430581, '武冈市', 430500, 1);
INSERT INTO `codeworld_area` VALUES (430600, '岳阳市', 430000, 1);
INSERT INTO `codeworld_area` VALUES (430601, '市辖区', 430600, 1);
INSERT INTO `codeworld_area` VALUES (430602, '岳阳楼区', 430601, 1);
INSERT INTO `codeworld_area` VALUES (430603, '云溪区', 430601, 1);
INSERT INTO `codeworld_area` VALUES (430611, '君山区', 430601, 1);
INSERT INTO `codeworld_area` VALUES (430621, '岳阳县', 430600, 1);
INSERT INTO `codeworld_area` VALUES (430623, '华容县', 430600, 1);
INSERT INTO `codeworld_area` VALUES (430624, '湘阴县', 430600, 1);
INSERT INTO `codeworld_area` VALUES (430626, '平江县', 430600, 1);
INSERT INTO `codeworld_area` VALUES (430681, '汨罗市', 430600, 1);
INSERT INTO `codeworld_area` VALUES (430682, '临湘市', 430600, 1);
INSERT INTO `codeworld_area` VALUES (430700, '常德市', 430000, 1);
INSERT INTO `codeworld_area` VALUES (430701, '市辖区', 430700, 1);
INSERT INTO `codeworld_area` VALUES (430702, '武陵区', 430701, 1);
INSERT INTO `codeworld_area` VALUES (430703, '鼎城区', 430701, 1);
INSERT INTO `codeworld_area` VALUES (430721, '安乡县', 430700, 1);
INSERT INTO `codeworld_area` VALUES (430722, '汉寿县', 430700, 1);
INSERT INTO `codeworld_area` VALUES (430723, '澧县', 430700, 1);
INSERT INTO `codeworld_area` VALUES (430724, '临澧县', 430700, 1);
INSERT INTO `codeworld_area` VALUES (430725, '桃源县', 430700, 1);
INSERT INTO `codeworld_area` VALUES (430726, '石门县', 430700, 1);
INSERT INTO `codeworld_area` VALUES (430781, '津市市', 430700, 1);
INSERT INTO `codeworld_area` VALUES (430800, '张家界市', 430000, 1);
INSERT INTO `codeworld_area` VALUES (430801, '市辖区', 430800, 1);
INSERT INTO `codeworld_area` VALUES (430802, '永定区', 430801, 1);
INSERT INTO `codeworld_area` VALUES (430811, '武陵源区', 430801, 1);
INSERT INTO `codeworld_area` VALUES (430821, '慈利县', 430800, 1);
INSERT INTO `codeworld_area` VALUES (430822, '桑植县', 430800, 1);
INSERT INTO `codeworld_area` VALUES (430900, '益阳市', 430000, 1);
INSERT INTO `codeworld_area` VALUES (430901, '市辖区', 430900, 1);
INSERT INTO `codeworld_area` VALUES (430902, '资阳区', 430901, 1);
INSERT INTO `codeworld_area` VALUES (430903, '赫山区', 430901, 1);
INSERT INTO `codeworld_area` VALUES (430921, '南县', 430900, 1);
INSERT INTO `codeworld_area` VALUES (430922, '桃江县', 430900, 1);
INSERT INTO `codeworld_area` VALUES (430923, '安化县', 430900, 1);
INSERT INTO `codeworld_area` VALUES (430981, '沅江市', 430900, 1);
INSERT INTO `codeworld_area` VALUES (431000, '郴州市', 430000, 1);
INSERT INTO `codeworld_area` VALUES (431001, '市辖区', 431000, 1);
INSERT INTO `codeworld_area` VALUES (431002, '北湖区', 431001, 1);
INSERT INTO `codeworld_area` VALUES (431003, '苏仙区', 431001, 1);
INSERT INTO `codeworld_area` VALUES (431021, '桂阳县', 431000, 1);
INSERT INTO `codeworld_area` VALUES (431022, '宜章县', 431000, 1);
INSERT INTO `codeworld_area` VALUES (431023, '永兴县', 431000, 1);
INSERT INTO `codeworld_area` VALUES (431024, '嘉禾县', 431000, 1);
INSERT INTO `codeworld_area` VALUES (431025, '临武县', 431000, 1);
INSERT INTO `codeworld_area` VALUES (431026, '汝城县', 431000, 1);
INSERT INTO `codeworld_area` VALUES (431027, '桂东县', 431000, 1);
INSERT INTO `codeworld_area` VALUES (431028, '安仁县', 431000, 1);
INSERT INTO `codeworld_area` VALUES (431081, '资兴市', 431000, 1);
INSERT INTO `codeworld_area` VALUES (431100, '永州市', 430000, 1);
INSERT INTO `codeworld_area` VALUES (431101, '市辖区', 431100, 1);
INSERT INTO `codeworld_area` VALUES (431102, '零陵区', 431101, 1);
INSERT INTO `codeworld_area` VALUES (431103, '冷水滩区', 431101, 1);
INSERT INTO `codeworld_area` VALUES (431121, '祁阳县', 431100, 1);
INSERT INTO `codeworld_area` VALUES (431122, '东安县', 431100, 1);
INSERT INTO `codeworld_area` VALUES (431123, '双牌县', 431100, 1);
INSERT INTO `codeworld_area` VALUES (431124, '道县', 431100, 1);
INSERT INTO `codeworld_area` VALUES (431125, '江永县', 431100, 1);
INSERT INTO `codeworld_area` VALUES (431126, '宁远县', 431100, 1);
INSERT INTO `codeworld_area` VALUES (431127, '蓝山县', 431100, 1);
INSERT INTO `codeworld_area` VALUES (431128, '新田县', 431100, 1);
INSERT INTO `codeworld_area` VALUES (431129, '江华瑶族自治县', 431100, 1);
INSERT INTO `codeworld_area` VALUES (431200, '怀化市', 430000, 1);
INSERT INTO `codeworld_area` VALUES (431201, '市辖区', 431200, 1);
INSERT INTO `codeworld_area` VALUES (431202, '鹤城区', 431201, 1);
INSERT INTO `codeworld_area` VALUES (431221, '中方县', 431200, 1);
INSERT INTO `codeworld_area` VALUES (431222, '沅陵县', 431200, 1);
INSERT INTO `codeworld_area` VALUES (431223, '辰溪县', 431200, 1);
INSERT INTO `codeworld_area` VALUES (431224, '溆浦县', 431200, 1);
INSERT INTO `codeworld_area` VALUES (431225, '会同县', 431200, 1);
INSERT INTO `codeworld_area` VALUES (431226, '麻阳苗族自治县', 431200, 1);
INSERT INTO `codeworld_area` VALUES (431227, '新晃侗族自治县', 431200, 1);
INSERT INTO `codeworld_area` VALUES (431228, '芷江侗族自治县', 431200, 1);
INSERT INTO `codeworld_area` VALUES (431229, '靖州苗族侗族自治县', 431200, 1);
INSERT INTO `codeworld_area` VALUES (431230, '通道侗族自治县', 431200, 1);
INSERT INTO `codeworld_area` VALUES (431281, '洪江市', 431200, 1);
INSERT INTO `codeworld_area` VALUES (431300, '娄底市', 430000, 1);
INSERT INTO `codeworld_area` VALUES (431301, '市辖区', 431300, 1);
INSERT INTO `codeworld_area` VALUES (431302, '娄星区', 431301, 1);
INSERT INTO `codeworld_area` VALUES (431321, '双峰县', 431300, 1);
INSERT INTO `codeworld_area` VALUES (431322, '新化县', 431300, 1);
INSERT INTO `codeworld_area` VALUES (431381, '冷水江市', 431300, 1);
INSERT INTO `codeworld_area` VALUES (431382, '涟源市', 431300, 1);
INSERT INTO `codeworld_area` VALUES (433100, '湘西土家族苗族自治州', 430000, 1);
INSERT INTO `codeworld_area` VALUES (433101, '吉首市', 433100, 1);
INSERT INTO `codeworld_area` VALUES (433122, '泸溪县', 433100, 1);
INSERT INTO `codeworld_area` VALUES (433123, '凤凰县', 433100, 1);
INSERT INTO `codeworld_area` VALUES (433124, '花垣县', 433100, 1);
INSERT INTO `codeworld_area` VALUES (433125, '保靖县', 433100, 1);
INSERT INTO `codeworld_area` VALUES (433126, '古丈县', 433100, 1);
INSERT INTO `codeworld_area` VALUES (433127, '永顺县', 433100, 1);
INSERT INTO `codeworld_area` VALUES (433130, '龙山县', 433100, 1);
INSERT INTO `codeworld_area` VALUES (440000, '广东省', 0, 1);
INSERT INTO `codeworld_area` VALUES (440100, '广州市', 440000, 1);
INSERT INTO `codeworld_area` VALUES (440101, '市辖区', 440100, 1);
INSERT INTO `codeworld_area` VALUES (440103, '荔湾区', 440101, 1);
INSERT INTO `codeworld_area` VALUES (440104, '越秀区', 440101, 1);
INSERT INTO `codeworld_area` VALUES (440105, '海珠区', 440101, 1);
INSERT INTO `codeworld_area` VALUES (440106, '天河区', 440101, 1);
INSERT INTO `codeworld_area` VALUES (440111, '白云区', 440101, 1);
INSERT INTO `codeworld_area` VALUES (440112, '黄埔区', 440101, 1);
INSERT INTO `codeworld_area` VALUES (440113, '番禺区', 440101, 1);
INSERT INTO `codeworld_area` VALUES (440114, '花都区', 440101, 1);
INSERT INTO `codeworld_area` VALUES (440115, '南沙区', 440101, 1);
INSERT INTO `codeworld_area` VALUES (440116, '萝岗区', 440101, 1);
INSERT INTO `codeworld_area` VALUES (440183, '增城市', 440100, 1);
INSERT INTO `codeworld_area` VALUES (440184, '从化市', 440100, 1);
INSERT INTO `codeworld_area` VALUES (440200, '韶关市', 440000, 1);
INSERT INTO `codeworld_area` VALUES (440201, '市辖区', 440200, 1);
INSERT INTO `codeworld_area` VALUES (440203, '武江区', 440201, 1);
INSERT INTO `codeworld_area` VALUES (440204, '浈江区', 440201, 1);
INSERT INTO `codeworld_area` VALUES (440205, '曲江区', 440201, 1);
INSERT INTO `codeworld_area` VALUES (440222, '始兴县', 440200, 1);
INSERT INTO `codeworld_area` VALUES (440224, '仁化县', 440200, 1);
INSERT INTO `codeworld_area` VALUES (440229, '翁源县', 440200, 1);
INSERT INTO `codeworld_area` VALUES (440232, '乳源瑶族自治县', 440200, 1);
INSERT INTO `codeworld_area` VALUES (440233, '新丰县', 440200, 1);
INSERT INTO `codeworld_area` VALUES (440281, '乐昌市', 440200, 1);
INSERT INTO `codeworld_area` VALUES (440282, '南雄市', 440200, 1);
INSERT INTO `codeworld_area` VALUES (440300, '深圳市', 440000, 1);
INSERT INTO `codeworld_area` VALUES (440301, '市辖区', 440300, 1);
INSERT INTO `codeworld_area` VALUES (440303, '罗湖区', 440301, 1);
INSERT INTO `codeworld_area` VALUES (440304, '福田区', 440301, 1);
INSERT INTO `codeworld_area` VALUES (440305, '南山区', 440301, 1);
INSERT INTO `codeworld_area` VALUES (440306, '宝安区', 440301, 1);
INSERT INTO `codeworld_area` VALUES (440307, '龙岗区', 440301, 1);
INSERT INTO `codeworld_area` VALUES (440308, '盐田区', 440301, 1);
INSERT INTO `codeworld_area` VALUES (440400, '珠海市', 440000, 1);
INSERT INTO `codeworld_area` VALUES (440401, '市辖区', 440400, 1);
INSERT INTO `codeworld_area` VALUES (440402, '香洲区', 440401, 1);
INSERT INTO `codeworld_area` VALUES (440403, '斗门区', 440401, 1);
INSERT INTO `codeworld_area` VALUES (440404, '金湾区', 440401, 1);
INSERT INTO `codeworld_area` VALUES (440500, '汕头市', 440000, 1);
INSERT INTO `codeworld_area` VALUES (440501, '市辖区', 440500, 1);
INSERT INTO `codeworld_area` VALUES (440507, '龙湖区', 440501, 1);
INSERT INTO `codeworld_area` VALUES (440511, '金平区', 440501, 1);
INSERT INTO `codeworld_area` VALUES (440512, '濠江区', 440501, 1);
INSERT INTO `codeworld_area` VALUES (440513, '潮阳区', 440501, 1);
INSERT INTO `codeworld_area` VALUES (440514, '潮南区', 440501, 1);
INSERT INTO `codeworld_area` VALUES (440515, '澄海区', 440501, 1);
INSERT INTO `codeworld_area` VALUES (440523, '南澳县', 440500, 1);
INSERT INTO `codeworld_area` VALUES (440600, '佛山市', 440000, 1);
INSERT INTO `codeworld_area` VALUES (440601, '市辖区', 440600, 1);
INSERT INTO `codeworld_area` VALUES (440604, '禅城区', 440600, 1);
INSERT INTO `codeworld_area` VALUES (440605, '南海区', 440600, 1);
INSERT INTO `codeworld_area` VALUES (440606, '顺德区', 440600, 1);
INSERT INTO `codeworld_area` VALUES (440607, '三水区', 440600, 1);
INSERT INTO `codeworld_area` VALUES (440608, '高明区', 440600, 1);
INSERT INTO `codeworld_area` VALUES (440700, '江门市', 440000, 1);
INSERT INTO `codeworld_area` VALUES (440701, '市辖区', 440700, 1);
INSERT INTO `codeworld_area` VALUES (440703, '蓬江区', 440701, 1);
INSERT INTO `codeworld_area` VALUES (440704, '江海区', 440701, 1);
INSERT INTO `codeworld_area` VALUES (440705, '新会区', 440701, 1);
INSERT INTO `codeworld_area` VALUES (440781, '台山市', 440700, 1);
INSERT INTO `codeworld_area` VALUES (440783, '开平市', 440700, 1);
INSERT INTO `codeworld_area` VALUES (440784, '鹤山市', 440700, 1);
INSERT INTO `codeworld_area` VALUES (440785, '恩平市', 440700, 1);
INSERT INTO `codeworld_area` VALUES (440800, '湛江市', 440000, 1);
INSERT INTO `codeworld_area` VALUES (440801, '市辖区', 440800, 1);
INSERT INTO `codeworld_area` VALUES (440802, '赤坎区', 440801, 1);
INSERT INTO `codeworld_area` VALUES (440803, '霞山区', 440801, 1);
INSERT INTO `codeworld_area` VALUES (440804, '坡头区', 440801, 1);
INSERT INTO `codeworld_area` VALUES (440811, '麻章区', 440801, 1);
INSERT INTO `codeworld_area` VALUES (440823, '遂溪县', 440800, 1);
INSERT INTO `codeworld_area` VALUES (440825, '徐闻县', 440800, 1);
INSERT INTO `codeworld_area` VALUES (440881, '廉江市', 440800, 1);
INSERT INTO `codeworld_area` VALUES (440882, '雷州市', 440800, 1);
INSERT INTO `codeworld_area` VALUES (440883, '吴川市', 440800, 1);
INSERT INTO `codeworld_area` VALUES (440900, '茂名市', 440000, 1);
INSERT INTO `codeworld_area` VALUES (440901, '市辖区', 440900, 1);
INSERT INTO `codeworld_area` VALUES (440902, '茂南区', 440901, 1);
INSERT INTO `codeworld_area` VALUES (440903, '茂港区', 440901, 1);
INSERT INTO `codeworld_area` VALUES (440923, '电白县', 440900, 1);
INSERT INTO `codeworld_area` VALUES (440981, '高州市', 440900, 1);
INSERT INTO `codeworld_area` VALUES (440982, '化州市', 440900, 1);
INSERT INTO `codeworld_area` VALUES (440983, '信宜市', 440900, 1);
INSERT INTO `codeworld_area` VALUES (441200, '肇庆市', 440000, 1);
INSERT INTO `codeworld_area` VALUES (441201, '市辖区', 441200, 1);
INSERT INTO `codeworld_area` VALUES (441202, '端州区', 441201, 1);
INSERT INTO `codeworld_area` VALUES (441203, '鼎湖区', 441201, 1);
INSERT INTO `codeworld_area` VALUES (441223, '广宁县', 441200, 1);
INSERT INTO `codeworld_area` VALUES (441224, '怀集县', 441200, 1);
INSERT INTO `codeworld_area` VALUES (441225, '封开县', 441200, 1);
INSERT INTO `codeworld_area` VALUES (441226, '德庆县', 441200, 1);
INSERT INTO `codeworld_area` VALUES (441283, '高要市', 441200, 1);
INSERT INTO `codeworld_area` VALUES (441284, '四会市', 441200, 1);
INSERT INTO `codeworld_area` VALUES (441300, '惠州市', 440000, 1);
INSERT INTO `codeworld_area` VALUES (441301, '市辖区', 441300, 1);
INSERT INTO `codeworld_area` VALUES (441302, '惠城区', 441301, 1);
INSERT INTO `codeworld_area` VALUES (441303, '惠阳区', 441301, 1);
INSERT INTO `codeworld_area` VALUES (441322, '博罗县', 441300, 1);
INSERT INTO `codeworld_area` VALUES (441323, '惠东县', 441300, 1);
INSERT INTO `codeworld_area` VALUES (441324, '龙门县', 441300, 1);
INSERT INTO `codeworld_area` VALUES (441400, '梅州市', 440000, 1);
INSERT INTO `codeworld_area` VALUES (441401, '市辖区', 441400, 1);
INSERT INTO `codeworld_area` VALUES (441402, '梅江区', 441401, 1);
INSERT INTO `codeworld_area` VALUES (441421, '梅县', 441400, 1);
INSERT INTO `codeworld_area` VALUES (441422, '大埔县', 441400, 1);
INSERT INTO `codeworld_area` VALUES (441423, '丰顺县', 441400, 1);
INSERT INTO `codeworld_area` VALUES (441424, '五华县', 441400, 1);
INSERT INTO `codeworld_area` VALUES (441426, '平远县', 441400, 1);
INSERT INTO `codeworld_area` VALUES (441427, '蕉岭县', 441400, 1);
INSERT INTO `codeworld_area` VALUES (441481, '兴宁市', 441400, 1);
INSERT INTO `codeworld_area` VALUES (441500, '汕尾市', 440000, 1);
INSERT INTO `codeworld_area` VALUES (441501, '市辖区', 441500, 1);
INSERT INTO `codeworld_area` VALUES (441502, '城区', 441501, 1);
INSERT INTO `codeworld_area` VALUES (441521, '海丰县', 441500, 1);
INSERT INTO `codeworld_area` VALUES (441523, '陆河县', 441500, 1);
INSERT INTO `codeworld_area` VALUES (441581, '陆丰市', 441500, 1);
INSERT INTO `codeworld_area` VALUES (441600, '河源市', 440000, 1);
INSERT INTO `codeworld_area` VALUES (441601, '市辖区', 441600, 1);
INSERT INTO `codeworld_area` VALUES (441602, '源城区', 441601, 1);
INSERT INTO `codeworld_area` VALUES (441621, '紫金县', 441600, 1);
INSERT INTO `codeworld_area` VALUES (441622, '龙川县', 441600, 1);
INSERT INTO `codeworld_area` VALUES (441623, '连平县', 441600, 1);
INSERT INTO `codeworld_area` VALUES (441624, '和平县', 441600, 1);
INSERT INTO `codeworld_area` VALUES (441625, '东源县', 441600, 1);
INSERT INTO `codeworld_area` VALUES (441700, '阳江市', 440000, 1);
INSERT INTO `codeworld_area` VALUES (441701, '市辖区', 441700, 1);
INSERT INTO `codeworld_area` VALUES (441702, '江城区', 441701, 1);
INSERT INTO `codeworld_area` VALUES (441721, '阳西县', 441700, 1);
INSERT INTO `codeworld_area` VALUES (441723, '阳东县', 441700, 1);
INSERT INTO `codeworld_area` VALUES (441781, '阳春市', 441700, 1);
INSERT INTO `codeworld_area` VALUES (441800, '清远市', 440000, 1);
INSERT INTO `codeworld_area` VALUES (441801, '市辖区', 441800, 1);
INSERT INTO `codeworld_area` VALUES (441802, '清城区', 441801, 1);
INSERT INTO `codeworld_area` VALUES (441821, '佛冈县', 441800, 1);
INSERT INTO `codeworld_area` VALUES (441823, '阳山县', 441800, 1);
INSERT INTO `codeworld_area` VALUES (441825, '连山壮族瑶族自治县', 441800, 1);
INSERT INTO `codeworld_area` VALUES (441826, '连南瑶族自治县', 441800, 1);
INSERT INTO `codeworld_area` VALUES (441827, '清新县', 441800, 1);
INSERT INTO `codeworld_area` VALUES (441881, '英德市', 441800, 1);
INSERT INTO `codeworld_area` VALUES (441882, '连州市', 441800, 1);
INSERT INTO `codeworld_area` VALUES (441900, '东莞市', 440000, 1);
INSERT INTO `codeworld_area` VALUES (442000, '中山市', 440000, 1);
INSERT INTO `codeworld_area` VALUES (445100, '潮州市', 440000, 1);
INSERT INTO `codeworld_area` VALUES (445101, '市辖区', 445100, 1);
INSERT INTO `codeworld_area` VALUES (445102, '湘桥区', 445101, 1);
INSERT INTO `codeworld_area` VALUES (445121, '潮安区', 445100, 1);
INSERT INTO `codeworld_area` VALUES (445122, '饶平县', 445100, 1);
INSERT INTO `codeworld_area` VALUES (445200, '揭阳市', 440000, 1);
INSERT INTO `codeworld_area` VALUES (445201, '市辖区', 445200, 1);
INSERT INTO `codeworld_area` VALUES (445202, '榕城区', 445201, 1);
INSERT INTO `codeworld_area` VALUES (445221, '揭东县', 445200, 1);
INSERT INTO `codeworld_area` VALUES (445222, '揭西县', 445200, 1);
INSERT INTO `codeworld_area` VALUES (445224, '惠来县', 445200, 1);
INSERT INTO `codeworld_area` VALUES (445281, '普宁市', 445200, 1);
INSERT INTO `codeworld_area` VALUES (445300, '云浮市', 440000, 1);
INSERT INTO `codeworld_area` VALUES (445301, '市辖区', 445300, 1);
INSERT INTO `codeworld_area` VALUES (445302, '云城区', 445301, 1);
INSERT INTO `codeworld_area` VALUES (445321, '新兴县', 445300, 1);
INSERT INTO `codeworld_area` VALUES (445322, '郁南县', 445300, 1);
INSERT INTO `codeworld_area` VALUES (445323, '云安县', 445300, 1);
INSERT INTO `codeworld_area` VALUES (445381, '罗定市', 445300, 1);
INSERT INTO `codeworld_area` VALUES (450000, '广西壮族自治区', 0, 1);
INSERT INTO `codeworld_area` VALUES (450100, '南宁市', 450000, 1);
INSERT INTO `codeworld_area` VALUES (450101, '市辖区', 450100, 1);
INSERT INTO `codeworld_area` VALUES (450102, '兴宁区', 450101, 1);
INSERT INTO `codeworld_area` VALUES (450103, '青秀区', 450101, 1);
INSERT INTO `codeworld_area` VALUES (450105, '江南区', 450101, 1);
INSERT INTO `codeworld_area` VALUES (450107, '西乡塘区', 450101, 1);
INSERT INTO `codeworld_area` VALUES (450108, '良庆区', 450101, 1);
INSERT INTO `codeworld_area` VALUES (450109, '邕宁区', 450101, 1);
INSERT INTO `codeworld_area` VALUES (450122, '武鸣县', 450100, 1);
INSERT INTO `codeworld_area` VALUES (450123, '隆安县', 450100, 1);
INSERT INTO `codeworld_area` VALUES (450124, '马山县', 450100, 1);
INSERT INTO `codeworld_area` VALUES (450125, '上林县', 450100, 1);
INSERT INTO `codeworld_area` VALUES (450126, '宾阳县', 450100, 1);
INSERT INTO `codeworld_area` VALUES (450127, '横县', 450100, 1);
INSERT INTO `codeworld_area` VALUES (450200, '柳州市', 450000, 1);
INSERT INTO `codeworld_area` VALUES (450201, '市辖区', 450200, 1);
INSERT INTO `codeworld_area` VALUES (450202, '城中区', 450201, 1);
INSERT INTO `codeworld_area` VALUES (450203, '鱼峰区', 450201, 1);
INSERT INTO `codeworld_area` VALUES (450204, '柳南区', 450201, 1);
INSERT INTO `codeworld_area` VALUES (450205, '柳北区', 450201, 1);
INSERT INTO `codeworld_area` VALUES (450221, '柳江县', 450200, 1);
INSERT INTO `codeworld_area` VALUES (450222, '柳城县', 450200, 1);
INSERT INTO `codeworld_area` VALUES (450223, '鹿寨县', 450200, 1);
INSERT INTO `codeworld_area` VALUES (450224, '融安县', 450200, 1);
INSERT INTO `codeworld_area` VALUES (450225, '融水苗族自治县', 450200, 1);
INSERT INTO `codeworld_area` VALUES (450226, '三江侗族自治县', 450200, 1);
INSERT INTO `codeworld_area` VALUES (450300, '桂林市', 450000, 1);
INSERT INTO `codeworld_area` VALUES (450301, '市辖区', 450300, 1);
INSERT INTO `codeworld_area` VALUES (450302, '秀峰区', 450301, 1);
INSERT INTO `codeworld_area` VALUES (450303, '叠彩区', 450301, 1);
INSERT INTO `codeworld_area` VALUES (450304, '象山区', 450301, 1);
INSERT INTO `codeworld_area` VALUES (450305, '七星区', 450301, 1);
INSERT INTO `codeworld_area` VALUES (450311, '雁山区', 450301, 1);
INSERT INTO `codeworld_area` VALUES (450321, '阳朔县', 450300, 1);
INSERT INTO `codeworld_area` VALUES (450322, '临桂区', 450300, 1);
INSERT INTO `codeworld_area` VALUES (450323, '灵川县', 450300, 1);
INSERT INTO `codeworld_area` VALUES (450324, '全州县', 450300, 1);
INSERT INTO `codeworld_area` VALUES (450325, '兴安县', 450300, 1);
INSERT INTO `codeworld_area` VALUES (450326, '永福县', 450300, 1);
INSERT INTO `codeworld_area` VALUES (450327, '灌阳县', 450300, 1);
INSERT INTO `codeworld_area` VALUES (450328, '龙胜各族自治县', 450300, 1);
INSERT INTO `codeworld_area` VALUES (450329, '资源县', 450300, 1);
INSERT INTO `codeworld_area` VALUES (450330, '平乐县', 450300, 1);
INSERT INTO `codeworld_area` VALUES (450331, '荔浦县', 450300, 1);
INSERT INTO `codeworld_area` VALUES (450332, '恭城瑶族自治县', 450300, 1);
INSERT INTO `codeworld_area` VALUES (450400, '梧州市', 450000, 1);
INSERT INTO `codeworld_area` VALUES (450401, '市辖区', 450400, 1);
INSERT INTO `codeworld_area` VALUES (450403, '万秀区', 450401, 1);
INSERT INTO `codeworld_area` VALUES (450404, '蝶山区', 450401, 1);
INSERT INTO `codeworld_area` VALUES (450405, '长洲区', 450401, 1);
INSERT INTO `codeworld_area` VALUES (450421, '苍梧县', 450400, 1);
INSERT INTO `codeworld_area` VALUES (450422, '藤县', 450400, 1);
INSERT INTO `codeworld_area` VALUES (450423, '蒙山县', 450400, 1);
INSERT INTO `codeworld_area` VALUES (450481, '岑溪市', 450400, 1);
INSERT INTO `codeworld_area` VALUES (450500, '北海市', 450000, 1);
INSERT INTO `codeworld_area` VALUES (450501, '市辖区', 450500, 1);
INSERT INTO `codeworld_area` VALUES (450502, '海城区', 450501, 1);
INSERT INTO `codeworld_area` VALUES (450503, '银海区', 450501, 1);
INSERT INTO `codeworld_area` VALUES (450512, '铁山港区', 450501, 1);
INSERT INTO `codeworld_area` VALUES (450521, '合浦县', 450500, 1);
INSERT INTO `codeworld_area` VALUES (450600, '防城港市', 450000, 1);
INSERT INTO `codeworld_area` VALUES (450601, '市辖区', 450600, 1);
INSERT INTO `codeworld_area` VALUES (450602, '港口区', 450601, 1);
INSERT INTO `codeworld_area` VALUES (450603, '防城区', 450601, 1);
INSERT INTO `codeworld_area` VALUES (450621, '上思县', 450600, 1);
INSERT INTO `codeworld_area` VALUES (450681, '东兴市', 450600, 1);
INSERT INTO `codeworld_area` VALUES (450700, '钦州市', 450000, 1);
INSERT INTO `codeworld_area` VALUES (450701, '市辖区', 450700, 1);
INSERT INTO `codeworld_area` VALUES (450702, '钦南区', 450700, 1);
INSERT INTO `codeworld_area` VALUES (450703, '钦北区', 450700, 1);
INSERT INTO `codeworld_area` VALUES (450721, '灵山县', 450700, 1);
INSERT INTO `codeworld_area` VALUES (450722, '浦北县', 450700, 1);
INSERT INTO `codeworld_area` VALUES (450800, '贵港市', 450000, 1);
INSERT INTO `codeworld_area` VALUES (450801, '市辖区', 450800, 1);
INSERT INTO `codeworld_area` VALUES (450802, '港北区', 450801, 1);
INSERT INTO `codeworld_area` VALUES (450803, '港南区', 450801, 1);
INSERT INTO `codeworld_area` VALUES (450804, '覃塘区', 450801, 1);
INSERT INTO `codeworld_area` VALUES (450821, '平南县', 450800, 1);
INSERT INTO `codeworld_area` VALUES (450881, '桂平市', 450800, 1);
INSERT INTO `codeworld_area` VALUES (450900, '玉林市', 450000, 1);
INSERT INTO `codeworld_area` VALUES (450901, '市辖区', 450900, 1);
INSERT INTO `codeworld_area` VALUES (450902, '玉州区', 450901, 1);
INSERT INTO `codeworld_area` VALUES (450921, '容县', 450900, 1);
INSERT INTO `codeworld_area` VALUES (450922, '陆川县', 450900, 1);
INSERT INTO `codeworld_area` VALUES (450923, '博白县', 450900, 1);
INSERT INTO `codeworld_area` VALUES (450924, '兴业县', 450900, 1);
INSERT INTO `codeworld_area` VALUES (450981, '北流市', 450900, 1);
INSERT INTO `codeworld_area` VALUES (451000, '百色市', 450000, 1);
INSERT INTO `codeworld_area` VALUES (451001, '市辖区', 451000, 1);
INSERT INTO `codeworld_area` VALUES (451002, '右江区', 451001, 1);
INSERT INTO `codeworld_area` VALUES (451021, '田阳县', 451000, 1);
INSERT INTO `codeworld_area` VALUES (451022, '田东县', 451000, 1);
INSERT INTO `codeworld_area` VALUES (451023, '平果县', 451000, 1);
INSERT INTO `codeworld_area` VALUES (451024, '德保县', 451000, 1);
INSERT INTO `codeworld_area` VALUES (451025, '靖西县', 451000, 1);
INSERT INTO `codeworld_area` VALUES (451026, '那坡县', 451000, 1);
INSERT INTO `codeworld_area` VALUES (451027, '凌云县', 451000, 1);
INSERT INTO `codeworld_area` VALUES (451028, '乐业县', 451000, 1);
INSERT INTO `codeworld_area` VALUES (451029, '田林县', 451000, 1);
INSERT INTO `codeworld_area` VALUES (451030, '西林县', 451000, 1);
INSERT INTO `codeworld_area` VALUES (451031, '隆林各族自治县', 451000, 1);
INSERT INTO `codeworld_area` VALUES (451100, '贺州市', 450000, 1);
INSERT INTO `codeworld_area` VALUES (451101, '市辖区', 451100, 1);
INSERT INTO `codeworld_area` VALUES (451102, '八步区', 451101, 1);
INSERT INTO `codeworld_area` VALUES (451121, '昭平县', 451100, 1);
INSERT INTO `codeworld_area` VALUES (451122, '钟山县', 451100, 1);
INSERT INTO `codeworld_area` VALUES (451123, '富川瑶族自治县', 451100, 1);
INSERT INTO `codeworld_area` VALUES (451200, '河池市', 450000, 1);
INSERT INTO `codeworld_area` VALUES (451201, '市辖区', 451200, 1);
INSERT INTO `codeworld_area` VALUES (451202, '金城江区', 451201, 1);
INSERT INTO `codeworld_area` VALUES (451221, '南丹县', 451200, 1);
INSERT INTO `codeworld_area` VALUES (451222, '天峨县', 451200, 1);
INSERT INTO `codeworld_area` VALUES (451223, '凤山县', 451200, 1);
INSERT INTO `codeworld_area` VALUES (451224, '东兰县', 451200, 1);
INSERT INTO `codeworld_area` VALUES (451225, '罗城仫佬族自治县', 451200, 1);
INSERT INTO `codeworld_area` VALUES (451226, '环江毛南族自治县', 451200, 1);
INSERT INTO `codeworld_area` VALUES (451227, '巴马瑶族自治县', 451200, 1);
INSERT INTO `codeworld_area` VALUES (451228, '都安瑶族自治县', 451200, 1);
INSERT INTO `codeworld_area` VALUES (451229, '大化瑶族自治县', 451200, 1);
INSERT INTO `codeworld_area` VALUES (451281, '宜州市', 451200, 1);
INSERT INTO `codeworld_area` VALUES (451300, '来宾市', 450000, 1);
INSERT INTO `codeworld_area` VALUES (451301, '市辖区', 451300, 1);
INSERT INTO `codeworld_area` VALUES (451302, '兴宾区', 451301, 1);
INSERT INTO `codeworld_area` VALUES (451321, '忻城县', 451300, 1);
INSERT INTO `codeworld_area` VALUES (451322, '象州县', 451300, 1);
INSERT INTO `codeworld_area` VALUES (451323, '武宣县', 451300, 1);
INSERT INTO `codeworld_area` VALUES (451324, '金秀瑶族自治县', 451300, 1);
INSERT INTO `codeworld_area` VALUES (451381, '合山市', 451300, 1);
INSERT INTO `codeworld_area` VALUES (451400, '崇左市', 450000, 1);
INSERT INTO `codeworld_area` VALUES (451401, '市辖区', 451400, 1);
INSERT INTO `codeworld_area` VALUES (451402, '江洲区', 451401, 1);
INSERT INTO `codeworld_area` VALUES (451421, '扶绥县', 451400, 1);
INSERT INTO `codeworld_area` VALUES (451422, '宁明县', 451400, 1);
INSERT INTO `codeworld_area` VALUES (451423, '龙州县', 451400, 1);
INSERT INTO `codeworld_area` VALUES (451424, '大新县', 451400, 1);
INSERT INTO `codeworld_area` VALUES (451425, '天等县', 451400, 1);
INSERT INTO `codeworld_area` VALUES (451481, '凭祥市', 451400, 1);
INSERT INTO `codeworld_area` VALUES (460000, '海南省', 0, 1);
INSERT INTO `codeworld_area` VALUES (460100, '海口市', 460000, 1);
INSERT INTO `codeworld_area` VALUES (460101, '市辖区', 460100, 1);
INSERT INTO `codeworld_area` VALUES (460105, '秀英区', 460101, 1);
INSERT INTO `codeworld_area` VALUES (460106, '龙华区', 460101, 1);
INSERT INTO `codeworld_area` VALUES (460107, '琼山区', 460101, 1);
INSERT INTO `codeworld_area` VALUES (460108, '美兰区', 460101, 1);
INSERT INTO `codeworld_area` VALUES (460200, '三亚市', 460000, 1);
INSERT INTO `codeworld_area` VALUES (460201, '市辖区', 460200, 1);
INSERT INTO `codeworld_area` VALUES (469000, '省直辖县级行政单位', 460000, 1);
INSERT INTO `codeworld_area` VALUES (469001, '五指山市', 469000, 1);
INSERT INTO `codeworld_area` VALUES (469002, '琼海市', 469000, 1);
INSERT INTO `codeworld_area` VALUES (469003, '儋州市', 469000, 1);
INSERT INTO `codeworld_area` VALUES (469005, '文昌市', 469000, 1);
INSERT INTO `codeworld_area` VALUES (469006, '万宁市', 469000, 1);
INSERT INTO `codeworld_area` VALUES (469007, '东方市', 469000, 1);
INSERT INTO `codeworld_area` VALUES (469025, '定安县', 469000, 1);
INSERT INTO `codeworld_area` VALUES (469026, '屯昌县', 469000, 1);
INSERT INTO `codeworld_area` VALUES (469027, '澄迈县', 469000, 1);
INSERT INTO `codeworld_area` VALUES (469028, '临高县', 469000, 1);
INSERT INTO `codeworld_area` VALUES (469030, '白沙黎族自治县', 469000, 1);
INSERT INTO `codeworld_area` VALUES (469031, '昌江黎族自治县', 469000, 1);
INSERT INTO `codeworld_area` VALUES (469033, '乐东黎族自治县', 469000, 1);
INSERT INTO `codeworld_area` VALUES (469034, '陵水黎族自治县', 469000, 1);
INSERT INTO `codeworld_area` VALUES (469035, '保亭黎族苗族自治县', 469000, 1);
INSERT INTO `codeworld_area` VALUES (469036, '琼中黎族苗族自治县', 469000, 1);
INSERT INTO `codeworld_area` VALUES (469037, '西沙群岛', 469000, 1);
INSERT INTO `codeworld_area` VALUES (469038, '南沙群岛', 469000, 1);
INSERT INTO `codeworld_area` VALUES (469039, '中沙群岛的岛礁及其海域', 469000, 1);
INSERT INTO `codeworld_area` VALUES (500000, '重庆市', 0, 1);
INSERT INTO `codeworld_area` VALUES (500100, '万州区', 500000, 1);
INSERT INTO `codeworld_area` VALUES (500101, '万州区', 500100, 1);
INSERT INTO `codeworld_area` VALUES (500200, '涪陵区', 500000, 1);
INSERT INTO `codeworld_area` VALUES (500201, '涪陵区', 500200, 1);
INSERT INTO `codeworld_area` VALUES (500300, '渝中区', 500000, 1);
INSERT INTO `codeworld_area` VALUES (500301, '渝中区', 500300, 1);
INSERT INTO `codeworld_area` VALUES (500400, '大渡口区', 500000, 1);
INSERT INTO `codeworld_area` VALUES (500401, '大渡口区', 500400, 1);
INSERT INTO `codeworld_area` VALUES (500500, '江北区', 500000, 1);
INSERT INTO `codeworld_area` VALUES (500501, '江北区', 500500, 1);
INSERT INTO `codeworld_area` VALUES (500600, '沙坪坝区', 500000, 1);
INSERT INTO `codeworld_area` VALUES (500601, '沙坪坝区', 500600, 1);
INSERT INTO `codeworld_area` VALUES (500700, '九龙坡区', 500000, 1);
INSERT INTO `codeworld_area` VALUES (500701, '九龙坡区', 500700, 1);
INSERT INTO `codeworld_area` VALUES (500800, '南岸区', 500000, 1);
INSERT INTO `codeworld_area` VALUES (500801, '南岸区', 500800, 1);
INSERT INTO `codeworld_area` VALUES (500900, '北碚区', 500000, 1);
INSERT INTO `codeworld_area` VALUES (500901, '北碚区', 500900, 1);
INSERT INTO `codeworld_area` VALUES (501000, '万盛区', 500000, 1);
INSERT INTO `codeworld_area` VALUES (501001, '万盛区', 501000, 1);
INSERT INTO `codeworld_area` VALUES (501100, '双桥区', 500000, 1);
INSERT INTO `codeworld_area` VALUES (501101, '双桥区', 501100, 1);
INSERT INTO `codeworld_area` VALUES (501200, '渝北区', 500000, 1);
INSERT INTO `codeworld_area` VALUES (501201, '渝北区', 501200, 1);
INSERT INTO `codeworld_area` VALUES (501300, '巴南区', 500000, 1);
INSERT INTO `codeworld_area` VALUES (501301, '巴南区', 501300, 1);
INSERT INTO `codeworld_area` VALUES (501400, '黔江区', 500000, 1);
INSERT INTO `codeworld_area` VALUES (501401, '黔江区', 501400, 1);
INSERT INTO `codeworld_area` VALUES (501500, '长寿区', 500000, 1);
INSERT INTO `codeworld_area` VALUES (501501, '长寿区', 501500, 1);
INSERT INTO `codeworld_area` VALUES (502200, '綦江区', 500000, 1);
INSERT INTO `codeworld_area` VALUES (502201, '綦江区', 502200, 1);
INSERT INTO `codeworld_area` VALUES (502300, '潼南县', 500000, 1);
INSERT INTO `codeworld_area` VALUES (502301, '潼南县', 502300, 1);
INSERT INTO `codeworld_area` VALUES (502400, '铜梁县', 500000, 1);
INSERT INTO `codeworld_area` VALUES (502401, '铜梁县', 502400, 1);
INSERT INTO `codeworld_area` VALUES (502500, '大足区', 500000, 1);
INSERT INTO `codeworld_area` VALUES (502501, '大足区', 502500, 1);
INSERT INTO `codeworld_area` VALUES (502600, '荣昌县', 500000, 1);
INSERT INTO `codeworld_area` VALUES (502601, '荣昌县', 502600, 1);
INSERT INTO `codeworld_area` VALUES (502700, '璧山县', 500000, 1);
INSERT INTO `codeworld_area` VALUES (502701, '璧山县', 502700, 1);
INSERT INTO `codeworld_area` VALUES (502800, '梁平县', 500000, 1);
INSERT INTO `codeworld_area` VALUES (502801, '梁平县', 502800, 1);
INSERT INTO `codeworld_area` VALUES (502900, '城口县', 500000, 1);
INSERT INTO `codeworld_area` VALUES (502901, '城口县', 502900, 1);
INSERT INTO `codeworld_area` VALUES (503000, '丰都县', 500000, 1);
INSERT INTO `codeworld_area` VALUES (503001, '丰都县', 503000, 1);
INSERT INTO `codeworld_area` VALUES (503100, '垫江县', 500000, 1);
INSERT INTO `codeworld_area` VALUES (503101, '垫江县', 503100, 1);
INSERT INTO `codeworld_area` VALUES (503200, '武隆县', 500000, 1);
INSERT INTO `codeworld_area` VALUES (503201, '武隆县', 503200, 1);
INSERT INTO `codeworld_area` VALUES (503300, '忠县', 500000, 1);
INSERT INTO `codeworld_area` VALUES (503301, '忠县', 503300, 1);
INSERT INTO `codeworld_area` VALUES (503400, '开县', 500000, 1);
INSERT INTO `codeworld_area` VALUES (503401, '开县', 503400, 1);
INSERT INTO `codeworld_area` VALUES (503500, '云阳县', 500000, 1);
INSERT INTO `codeworld_area` VALUES (503501, '云阳县', 503500, 1);
INSERT INTO `codeworld_area` VALUES (503600, '奉节县', 500000, 1);
INSERT INTO `codeworld_area` VALUES (503601, '奉节县', 503600, 1);
INSERT INTO `codeworld_area` VALUES (503700, '巫山县', 500000, 1);
INSERT INTO `codeworld_area` VALUES (503701, '巫山县', 503700, 1);
INSERT INTO `codeworld_area` VALUES (503800, '巫溪县', 500000, 1);
INSERT INTO `codeworld_area` VALUES (503801, '巫溪县', 503800, 1);
INSERT INTO `codeworld_area` VALUES (504000, '石柱县', 500000, 1);
INSERT INTO `codeworld_area` VALUES (504001, '石柱县', 504000, 1);
INSERT INTO `codeworld_area` VALUES (504100, '秀山县', 500000, 1);
INSERT INTO `codeworld_area` VALUES (504101, '秀山县', 504100, 1);
INSERT INTO `codeworld_area` VALUES (504200, '酉阳县', 500000, 1);
INSERT INTO `codeworld_area` VALUES (504201, '酉阳县', 504200, 1);
INSERT INTO `codeworld_area` VALUES (504300, '彭水县', 500000, 1);
INSERT INTO `codeworld_area` VALUES (504301, '彭水县', 504300, 1);
INSERT INTO `codeworld_area` VALUES (508100, '江津区', 500000, 1);
INSERT INTO `codeworld_area` VALUES (508101, '江津区', 508100, 1);
INSERT INTO `codeworld_area` VALUES (508200, '合川区', 500000, 1);
INSERT INTO `codeworld_area` VALUES (508201, '合川区', 508200, 1);
INSERT INTO `codeworld_area` VALUES (508300, '永川区', 500000, 1);
INSERT INTO `codeworld_area` VALUES (508301, '永川区', 508300, 1);
INSERT INTO `codeworld_area` VALUES (508400, '南川区', 500000, 1);
INSERT INTO `codeworld_area` VALUES (508401, '南川区', 508400, 1);
INSERT INTO `codeworld_area` VALUES (510000, '四川省', 0, 1);
INSERT INTO `codeworld_area` VALUES (510100, '成都市', 510000, 1);
INSERT INTO `codeworld_area` VALUES (510101, '市辖区', 510100, 1);
INSERT INTO `codeworld_area` VALUES (510104, '锦江区', 510101, 1);
INSERT INTO `codeworld_area` VALUES (510105, '青羊区', 510101, 1);
INSERT INTO `codeworld_area` VALUES (510106, '金牛区', 510101, 1);
INSERT INTO `codeworld_area` VALUES (510107, '武侯区', 510101, 1);
INSERT INTO `codeworld_area` VALUES (510108, '成华区', 510101, 1);
INSERT INTO `codeworld_area` VALUES (510112, '龙泉驿区', 510100, 1);
INSERT INTO `codeworld_area` VALUES (510113, '青白江区', 510101, 1);
INSERT INTO `codeworld_area` VALUES (510114, '新都区', 510101, 1);
INSERT INTO `codeworld_area` VALUES (510115, '温江区', 510101, 1);
INSERT INTO `codeworld_area` VALUES (510121, '金堂县', 510100, 1);
INSERT INTO `codeworld_area` VALUES (510122, '双流县', 510100, 1);
INSERT INTO `codeworld_area` VALUES (510124, '郫县', 510100, 1);
INSERT INTO `codeworld_area` VALUES (510129, '大邑县', 510100, 1);
INSERT INTO `codeworld_area` VALUES (510131, '蒲江县', 510100, 1);
INSERT INTO `codeworld_area` VALUES (510132, '新津县', 510100, 1);
INSERT INTO `codeworld_area` VALUES (510181, '都江堰市', 510100, 1);
INSERT INTO `codeworld_area` VALUES (510182, '彭州市', 510100, 1);
INSERT INTO `codeworld_area` VALUES (510183, '邛崃市', 510100, 1);
INSERT INTO `codeworld_area` VALUES (510184, '崇州市', 510100, 1);
INSERT INTO `codeworld_area` VALUES (510300, '自贡市', 510000, 1);
INSERT INTO `codeworld_area` VALUES (510301, '市辖区', 510300, 1);
INSERT INTO `codeworld_area` VALUES (510302, '自流井区', 510301, 1);
INSERT INTO `codeworld_area` VALUES (510303, '贡井区', 510301, 1);
INSERT INTO `codeworld_area` VALUES (510304, '大安区', 510301, 1);
INSERT INTO `codeworld_area` VALUES (510311, '沿滩区', 510301, 1);
INSERT INTO `codeworld_area` VALUES (510321, '荣县', 510300, 1);
INSERT INTO `codeworld_area` VALUES (510322, '富顺县', 510300, 1);
INSERT INTO `codeworld_area` VALUES (510400, '攀枝花市', 510000, 1);
INSERT INTO `codeworld_area` VALUES (510401, '市辖区', 510400, 1);
INSERT INTO `codeworld_area` VALUES (510402, '东区', 510401, 1);
INSERT INTO `codeworld_area` VALUES (510403, '西区', 510401, 1);
INSERT INTO `codeworld_area` VALUES (510411, '仁和区', 510401, 1);
INSERT INTO `codeworld_area` VALUES (510421, '米易县', 510400, 1);
INSERT INTO `codeworld_area` VALUES (510422, '盐边县', 510400, 1);
INSERT INTO `codeworld_area` VALUES (510500, '泸州市', 510000, 1);
INSERT INTO `codeworld_area` VALUES (510501, '市辖区', 510500, 1);
INSERT INTO `codeworld_area` VALUES (510502, '江阳区', 510501, 1);
INSERT INTO `codeworld_area` VALUES (510503, '纳溪区', 510501, 1);
INSERT INTO `codeworld_area` VALUES (510504, '龙马潭区', 510501, 1);
INSERT INTO `codeworld_area` VALUES (510521, '泸县', 510500, 1);
INSERT INTO `codeworld_area` VALUES (510522, '合江县', 510500, 1);
INSERT INTO `codeworld_area` VALUES (510524, '叙永县', 510500, 1);
INSERT INTO `codeworld_area` VALUES (510525, '古蔺县', 510500, 1);
INSERT INTO `codeworld_area` VALUES (510600, '德阳市', 510000, 1);
INSERT INTO `codeworld_area` VALUES (510601, '市辖区', 510600, 1);
INSERT INTO `codeworld_area` VALUES (510603, '旌阳区', 510601, 1);
INSERT INTO `codeworld_area` VALUES (510623, '中江县', 510600, 1);
INSERT INTO `codeworld_area` VALUES (510626, '罗江县', 510600, 1);
INSERT INTO `codeworld_area` VALUES (510681, '广汉市', 510600, 1);
INSERT INTO `codeworld_area` VALUES (510682, '什邡市', 510600, 1);
INSERT INTO `codeworld_area` VALUES (510683, '绵竹市', 510600, 1);
INSERT INTO `codeworld_area` VALUES (510700, '绵阳市', 510000, 1);
INSERT INTO `codeworld_area` VALUES (510701, '市辖区', 510700, 1);
INSERT INTO `codeworld_area` VALUES (510703, '涪城区', 510701, 1);
INSERT INTO `codeworld_area` VALUES (510704, '游仙区', 510701, 1);
INSERT INTO `codeworld_area` VALUES (510722, '三台县', 510700, 1);
INSERT INTO `codeworld_area` VALUES (510723, '盐亭县', 510700, 1);
INSERT INTO `codeworld_area` VALUES (510724, '安县', 510700, 1);
INSERT INTO `codeworld_area` VALUES (510725, '梓潼县', 510700, 1);
INSERT INTO `codeworld_area` VALUES (510726, '北川羌族自治县', 510700, 1);
INSERT INTO `codeworld_area` VALUES (510727, '平武县', 510700, 1);
INSERT INTO `codeworld_area` VALUES (510781, '江油市', 510700, 1);
INSERT INTO `codeworld_area` VALUES (510800, '广元市', 510000, 1);
INSERT INTO `codeworld_area` VALUES (510801, '市辖区', 510800, 1);
INSERT INTO `codeworld_area` VALUES (510802, '市中区', 510801, 1);
INSERT INTO `codeworld_area` VALUES (510811, '元坝区', 510801, 1);
INSERT INTO `codeworld_area` VALUES (510812, '朝天区', 510801, 1);
INSERT INTO `codeworld_area` VALUES (510821, '旺苍县', 510800, 1);
INSERT INTO `codeworld_area` VALUES (510822, '青川县', 510800, 1);
INSERT INTO `codeworld_area` VALUES (510823, '剑阁县', 510800, 1);
INSERT INTO `codeworld_area` VALUES (510824, '苍溪县', 510800, 1);
INSERT INTO `codeworld_area` VALUES (510900, '遂宁市', 510000, 1);
INSERT INTO `codeworld_area` VALUES (510901, '市辖区', 510900, 1);
INSERT INTO `codeworld_area` VALUES (510903, '船山区', 510901, 1);
INSERT INTO `codeworld_area` VALUES (510904, '安居区', 510901, 1);
INSERT INTO `codeworld_area` VALUES (510921, '蓬溪县', 510900, 1);
INSERT INTO `codeworld_area` VALUES (510922, '射洪县', 510900, 1);
INSERT INTO `codeworld_area` VALUES (510923, '大英县', 510900, 1);
INSERT INTO `codeworld_area` VALUES (511000, '内江市', 510000, 1);
INSERT INTO `codeworld_area` VALUES (511001, '市辖区', 511000, 1);
INSERT INTO `codeworld_area` VALUES (511002, '市中区', 511001, 1);
INSERT INTO `codeworld_area` VALUES (511011, '东兴区', 511001, 1);
INSERT INTO `codeworld_area` VALUES (511024, '威远县', 511000, 1);
INSERT INTO `codeworld_area` VALUES (511025, '资中县', 511000, 1);
INSERT INTO `codeworld_area` VALUES (511028, '隆昌县', 511000, 1);
INSERT INTO `codeworld_area` VALUES (511100, '乐山市', 510000, 1);
INSERT INTO `codeworld_area` VALUES (511101, '市辖区', 511100, 1);
INSERT INTO `codeworld_area` VALUES (511102, '市中区', 511101, 1);
INSERT INTO `codeworld_area` VALUES (511111, '沙湾区', 511101, 1);
INSERT INTO `codeworld_area` VALUES (511112, '五通桥区', 511101, 1);
INSERT INTO `codeworld_area` VALUES (511113, '金口河区', 511101, 1);
INSERT INTO `codeworld_area` VALUES (511123, '犍为县', 511100, 1);
INSERT INTO `codeworld_area` VALUES (511124, '井研县', 511100, 1);
INSERT INTO `codeworld_area` VALUES (511126, '夹江县', 511100, 1);
INSERT INTO `codeworld_area` VALUES (511129, '沐川县', 511100, 1);
INSERT INTO `codeworld_area` VALUES (511132, '峨边彝族自治县', 511100, 1);
INSERT INTO `codeworld_area` VALUES (511133, '马边彝族自治县', 511100, 1);
INSERT INTO `codeworld_area` VALUES (511181, '峨眉山市', 511100, 1);
INSERT INTO `codeworld_area` VALUES (511300, '南充市', 510000, 1);
INSERT INTO `codeworld_area` VALUES (511301, '市辖区', 511300, 1);
INSERT INTO `codeworld_area` VALUES (511302, '顺庆区', 511301, 1);
INSERT INTO `codeworld_area` VALUES (511303, '高坪区', 511301, 1);
INSERT INTO `codeworld_area` VALUES (511304, '嘉陵区', 511301, 1);
INSERT INTO `codeworld_area` VALUES (511321, '南部县', 511300, 1);
INSERT INTO `codeworld_area` VALUES (511322, '营山县', 511300, 1);
INSERT INTO `codeworld_area` VALUES (511323, '蓬安县', 511300, 1);
INSERT INTO `codeworld_area` VALUES (511324, '仪陇县', 511300, 1);
INSERT INTO `codeworld_area` VALUES (511325, '西充县', 511300, 1);
INSERT INTO `codeworld_area` VALUES (511381, '阆中市', 511300, 1);
INSERT INTO `codeworld_area` VALUES (511400, '眉山市', 510000, 1);
INSERT INTO `codeworld_area` VALUES (511401, '市辖区', 511400, 1);
INSERT INTO `codeworld_area` VALUES (511402, '东坡区', 511401, 1);
INSERT INTO `codeworld_area` VALUES (511421, '仁寿县', 511400, 1);
INSERT INTO `codeworld_area` VALUES (511422, '彭山县', 511400, 1);
INSERT INTO `codeworld_area` VALUES (511423, '洪雅县', 511400, 1);
INSERT INTO `codeworld_area` VALUES (511424, '丹棱县', 511400, 1);
INSERT INTO `codeworld_area` VALUES (511425, '青神县', 511400, 1);
INSERT INTO `codeworld_area` VALUES (511500, '宜宾市', 510000, 1);
INSERT INTO `codeworld_area` VALUES (511501, '市辖区', 511500, 1);
INSERT INTO `codeworld_area` VALUES (511502, '翠屏区', 511500, 1);
INSERT INTO `codeworld_area` VALUES (511521, '宜宾县', 511500, 1);
INSERT INTO `codeworld_area` VALUES (511522, '南溪县', 511500, 1);
INSERT INTO `codeworld_area` VALUES (511523, '江安县', 511500, 1);
INSERT INTO `codeworld_area` VALUES (511524, '长宁县', 511500, 1);
INSERT INTO `codeworld_area` VALUES (511525, '高县', 511500, 1);
INSERT INTO `codeworld_area` VALUES (511526, '珙县', 511500, 1);
INSERT INTO `codeworld_area` VALUES (511527, '筠连县', 511500, 1);
INSERT INTO `codeworld_area` VALUES (511528, '兴文县', 511500, 1);
INSERT INTO `codeworld_area` VALUES (511529, '屏山县', 511500, 1);
INSERT INTO `codeworld_area` VALUES (511600, '广安市', 510000, 1);
INSERT INTO `codeworld_area` VALUES (511601, '市辖区', 511600, 1);
INSERT INTO `codeworld_area` VALUES (511602, '广安区', 511601, 1);
INSERT INTO `codeworld_area` VALUES (511621, '岳池县', 511600, 1);
INSERT INTO `codeworld_area` VALUES (511622, '武胜县', 511600, 1);
INSERT INTO `codeworld_area` VALUES (511623, '邻水县', 511600, 1);
INSERT INTO `codeworld_area` VALUES (511681, '华蓥市', 511600, 1);
INSERT INTO `codeworld_area` VALUES (511682, '广安区', 511600, 1);
INSERT INTO `codeworld_area` VALUES (511700, '达州市', 510000, 1);
INSERT INTO `codeworld_area` VALUES (511701, '市辖区', 511700, 1);
INSERT INTO `codeworld_area` VALUES (511702, '通川区', 511701, 1);
INSERT INTO `codeworld_area` VALUES (511721, '达川区', 511700, 1);
INSERT INTO `codeworld_area` VALUES (511722, '宣汉县', 511700, 1);
INSERT INTO `codeworld_area` VALUES (511723, '开江县', 511700, 1);
INSERT INTO `codeworld_area` VALUES (511724, '大竹县', 511700, 1);
INSERT INTO `codeworld_area` VALUES (511725, '渠县', 511700, 1);
INSERT INTO `codeworld_area` VALUES (511781, '万源市', 511700, 1);
INSERT INTO `codeworld_area` VALUES (511800, '雅安市', 510000, 1);
INSERT INTO `codeworld_area` VALUES (511801, '雨城区', 511800, 1);
INSERT INTO `codeworld_area` VALUES (511802, '雨城区', 511801, 1);
INSERT INTO `codeworld_area` VALUES (511821, '名山区', 511800, 1);
INSERT INTO `codeworld_area` VALUES (511822, '荥经县', 511800, 1);
INSERT INTO `codeworld_area` VALUES (511823, '汉源县', 511800, 1);
INSERT INTO `codeworld_area` VALUES (511824, '石棉县', 511800, 1);
INSERT INTO `codeworld_area` VALUES (511825, '天全县', 511800, 1);
INSERT INTO `codeworld_area` VALUES (511826, '芦山县', 511800, 1);
INSERT INTO `codeworld_area` VALUES (511827, '宝兴县', 511800, 1);
INSERT INTO `codeworld_area` VALUES (511900, '巴中市', 510000, 1);
INSERT INTO `codeworld_area` VALUES (511901, '市辖区', 511900, 1);
INSERT INTO `codeworld_area` VALUES (511902, '巴州区', 511901, 1);
INSERT INTO `codeworld_area` VALUES (511921, '通江县', 511900, 1);
INSERT INTO `codeworld_area` VALUES (511922, '南江县', 511900, 1);
INSERT INTO `codeworld_area` VALUES (511923, '平昌县', 511900, 1);
INSERT INTO `codeworld_area` VALUES (512000, '资阳市', 510000, 1);
INSERT INTO `codeworld_area` VALUES (512001, '市辖区', 512000, 1);
INSERT INTO `codeworld_area` VALUES (512002, '雁江区', 512001, 1);
INSERT INTO `codeworld_area` VALUES (512021, '安岳县', 512000, 1);
INSERT INTO `codeworld_area` VALUES (512022, '乐至县', 512000, 1);
INSERT INTO `codeworld_area` VALUES (512081, '简阳市', 512000, 1);
INSERT INTO `codeworld_area` VALUES (513200, '阿坝藏族羌族自治州', 510000, 1);
INSERT INTO `codeworld_area` VALUES (513221, '汶川县', 513200, 1);
INSERT INTO `codeworld_area` VALUES (513222, '理县', 513200, 1);
INSERT INTO `codeworld_area` VALUES (513223, '茂县', 513200, 1);
INSERT INTO `codeworld_area` VALUES (513224, '松潘县', 513200, 1);
INSERT INTO `codeworld_area` VALUES (513225, '九寨沟县', 513200, 1);
INSERT INTO `codeworld_area` VALUES (513226, '金川县', 513200, 1);
INSERT INTO `codeworld_area` VALUES (513227, '小金县', 513200, 1);
INSERT INTO `codeworld_area` VALUES (513228, '黑水县', 513200, 1);
INSERT INTO `codeworld_area` VALUES (513229, '马尔康县', 513200, 1);
INSERT INTO `codeworld_area` VALUES (513230, '壤塘县', 513200, 1);
INSERT INTO `codeworld_area` VALUES (513231, '阿坝县', 513200, 1);
INSERT INTO `codeworld_area` VALUES (513232, '若尔盖县', 513200, 1);
INSERT INTO `codeworld_area` VALUES (513233, '红原县', 513200, 1);
INSERT INTO `codeworld_area` VALUES (513300, '甘孜藏族自治州', 510000, 1);
INSERT INTO `codeworld_area` VALUES (513321, '康定县', 513300, 1);
INSERT INTO `codeworld_area` VALUES (513322, '泸定县', 513300, 1);
INSERT INTO `codeworld_area` VALUES (513323, '丹巴县', 513300, 1);
INSERT INTO `codeworld_area` VALUES (513324, '九龙县', 513300, 1);
INSERT INTO `codeworld_area` VALUES (513325, '雅江县', 513300, 1);
INSERT INTO `codeworld_area` VALUES (513326, '道孚县', 513300, 1);
INSERT INTO `codeworld_area` VALUES (513327, '炉霍县', 513300, 1);
INSERT INTO `codeworld_area` VALUES (513328, '甘孜县', 513300, 1);
INSERT INTO `codeworld_area` VALUES (513329, '新龙县', 513300, 1);
INSERT INTO `codeworld_area` VALUES (513330, '德格县', 513300, 1);
INSERT INTO `codeworld_area` VALUES (513331, '白玉县', 513300, 1);
INSERT INTO `codeworld_area` VALUES (513332, '石渠县', 513300, 1);
INSERT INTO `codeworld_area` VALUES (513333, '色达县', 513300, 1);
INSERT INTO `codeworld_area` VALUES (513334, '理塘县', 513300, 1);
INSERT INTO `codeworld_area` VALUES (513335, '巴塘县', 513300, 1);
INSERT INTO `codeworld_area` VALUES (513336, '乡城县', 513300, 1);
INSERT INTO `codeworld_area` VALUES (513337, '稻城县', 513300, 1);
INSERT INTO `codeworld_area` VALUES (513338, '得荣县', 513300, 1);
INSERT INTO `codeworld_area` VALUES (513400, '凉山彝族自治州', 510000, 1);
INSERT INTO `codeworld_area` VALUES (513401, '西昌市', 513400, 1);
INSERT INTO `codeworld_area` VALUES (513422, '木里藏族自治县', 513400, 1);
INSERT INTO `codeworld_area` VALUES (513423, '盐源县', 513400, 1);
INSERT INTO `codeworld_area` VALUES (513424, '德昌县', 513400, 1);
INSERT INTO `codeworld_area` VALUES (513425, '会理县', 513400, 1);
INSERT INTO `codeworld_area` VALUES (513426, '会东县', 513400, 1);
INSERT INTO `codeworld_area` VALUES (513427, '宁南县', 513400, 1);
INSERT INTO `codeworld_area` VALUES (513428, '普格县', 513400, 1);
INSERT INTO `codeworld_area` VALUES (513429, '布拖县', 513400, 1);
INSERT INTO `codeworld_area` VALUES (513430, '金阳县', 513400, 1);
INSERT INTO `codeworld_area` VALUES (513431, '昭觉县', 513400, 1);
INSERT INTO `codeworld_area` VALUES (513432, '喜德县', 513400, 1);
INSERT INTO `codeworld_area` VALUES (513433, '冕宁县', 513400, 1);
INSERT INTO `codeworld_area` VALUES (513434, '越西县', 513400, 1);
INSERT INTO `codeworld_area` VALUES (513435, '甘洛县', 513400, 1);
INSERT INTO `codeworld_area` VALUES (513436, '美姑县', 513400, 1);
INSERT INTO `codeworld_area` VALUES (513437, '雷波县', 513400, 1);
INSERT INTO `codeworld_area` VALUES (520000, '贵州省', 0, 1);
INSERT INTO `codeworld_area` VALUES (520100, '贵阳市', 520000, 1);
INSERT INTO `codeworld_area` VALUES (520101, '市辖区', 520100, 1);
INSERT INTO `codeworld_area` VALUES (520102, '南明区', 520101, 1);
INSERT INTO `codeworld_area` VALUES (520103, '云岩区', 520101, 1);
INSERT INTO `codeworld_area` VALUES (520111, '花溪区', 520101, 1);
INSERT INTO `codeworld_area` VALUES (520112, '乌当区', 520100, 1);
INSERT INTO `codeworld_area` VALUES (520113, '白云区', 520101, 1);
INSERT INTO `codeworld_area` VALUES (520114, '小河区', 520101, 1);
INSERT INTO `codeworld_area` VALUES (520121, '开阳县', 520100, 1);
INSERT INTO `codeworld_area` VALUES (520122, '息烽县', 520100, 1);
INSERT INTO `codeworld_area` VALUES (520123, '修文县', 520100, 1);
INSERT INTO `codeworld_area` VALUES (520181, '清镇市', 520100, 1);
INSERT INTO `codeworld_area` VALUES (520200, '六盘水市', 520000, 1);
INSERT INTO `codeworld_area` VALUES (520201, '钟山区', 520200, 1);
INSERT INTO `codeworld_area` VALUES (520203, '六枝特区', 520200, 1);
INSERT INTO `codeworld_area` VALUES (520221, '水城县', 520200, 1);
INSERT INTO `codeworld_area` VALUES (520222, '盘县', 520200, 1);
INSERT INTO `codeworld_area` VALUES (520300, '遵义市', 520000, 1);
INSERT INTO `codeworld_area` VALUES (520301, '市辖区', 520300, 1);
INSERT INTO `codeworld_area` VALUES (520302, '红花岗区', 520301, 1);
INSERT INTO `codeworld_area` VALUES (520303, '汇川区', 520301, 1);
INSERT INTO `codeworld_area` VALUES (520321, '遵义县', 520300, 1);
INSERT INTO `codeworld_area` VALUES (520322, '桐梓县', 520300, 1);
INSERT INTO `codeworld_area` VALUES (520323, '绥阳县', 520300, 1);
INSERT INTO `codeworld_area` VALUES (520324, '正安县', 520300, 1);
INSERT INTO `codeworld_area` VALUES (520325, '道真仡佬族苗族自治县', 520300, 1);
INSERT INTO `codeworld_area` VALUES (520326, '务川仡佬族苗族自治县', 520300, 1);
INSERT INTO `codeworld_area` VALUES (520327, '凤冈县', 520300, 1);
INSERT INTO `codeworld_area` VALUES (520328, '湄潭县', 520300, 1);
INSERT INTO `codeworld_area` VALUES (520329, '余庆县', 520300, 1);
INSERT INTO `codeworld_area` VALUES (520330, '习水县', 520300, 1);
INSERT INTO `codeworld_area` VALUES (520381, '赤水市', 520300, 1);
INSERT INTO `codeworld_area` VALUES (520382, '仁怀市', 520300, 1);
INSERT INTO `codeworld_area` VALUES (520400, '安顺市', 520000, 1);
INSERT INTO `codeworld_area` VALUES (520401, '市辖区', 520400, 1);
INSERT INTO `codeworld_area` VALUES (520402, '西秀区', 520401, 1);
INSERT INTO `codeworld_area` VALUES (520421, '平坝县', 520400, 1);
INSERT INTO `codeworld_area` VALUES (520422, '普定县', 520400, 1);
INSERT INTO `codeworld_area` VALUES (520423, '镇宁布依族苗族自治县', 520400, 1);
INSERT INTO `codeworld_area` VALUES (520424, '关岭布依族苗族自治县', 520400, 1);
INSERT INTO `codeworld_area` VALUES (520425, '紫云苗族布依族自治县', 520400, 1);
INSERT INTO `codeworld_area` VALUES (522200, '铜仁市', 520000, 1);
INSERT INTO `codeworld_area` VALUES (522201, '碧江区', 522200, 1);
INSERT INTO `codeworld_area` VALUES (522222, '江口县', 522200, 1);
INSERT INTO `codeworld_area` VALUES (522223, '玉屏侗族自治县', 522200, 1);
INSERT INTO `codeworld_area` VALUES (522224, '石阡县', 522200, 1);
INSERT INTO `codeworld_area` VALUES (522225, '思南县', 522200, 1);
INSERT INTO `codeworld_area` VALUES (522226, '印江土家族苗族自治县', 522200, 1);
INSERT INTO `codeworld_area` VALUES (522227, '德江县', 522200, 1);
INSERT INTO `codeworld_area` VALUES (522228, '沿河土家族自治县', 522200, 1);
INSERT INTO `codeworld_area` VALUES (522229, '松桃苗族自治县', 522200, 1);
INSERT INTO `codeworld_area` VALUES (522230, '万山区', 522200, 1);
INSERT INTO `codeworld_area` VALUES (522300, '黔西南布依族苗族自治州', 520000, 1);
INSERT INTO `codeworld_area` VALUES (522301, '兴义市', 522300, 1);
INSERT INTO `codeworld_area` VALUES (522322, '兴仁县', 522300, 1);
INSERT INTO `codeworld_area` VALUES (522323, '普安县', 522300, 1);
INSERT INTO `codeworld_area` VALUES (522324, '晴隆县', 522300, 1);
INSERT INTO `codeworld_area` VALUES (522325, '贞丰县', 522300, 1);
INSERT INTO `codeworld_area` VALUES (522326, '望谟县', 522300, 1);
INSERT INTO `codeworld_area` VALUES (522327, '册亨县', 522300, 1);
INSERT INTO `codeworld_area` VALUES (522328, '安龙县', 522300, 1);
INSERT INTO `codeworld_area` VALUES (522400, '毕节市', 520000, 1);
INSERT INTO `codeworld_area` VALUES (522401, '七星关区', 522400, 1);
INSERT INTO `codeworld_area` VALUES (522422, '大方县', 522400, 1);
INSERT INTO `codeworld_area` VALUES (522423, '黔西县', 522400, 1);
INSERT INTO `codeworld_area` VALUES (522424, '金沙县', 522400, 1);
INSERT INTO `codeworld_area` VALUES (522425, '织金县', 522400, 1);
INSERT INTO `codeworld_area` VALUES (522426, '纳雍县', 522400, 1);
INSERT INTO `codeworld_area` VALUES (522427, '威宁彝族回族苗族自治县', 522400, 1);
INSERT INTO `codeworld_area` VALUES (522428, '赫章县', 522400, 1);
INSERT INTO `codeworld_area` VALUES (522600, '黔东南苗族侗族自治州', 520000, 1);
INSERT INTO `codeworld_area` VALUES (522601, '凯里市', 522600, 1);
INSERT INTO `codeworld_area` VALUES (522622, '黄平县', 522600, 1);
INSERT INTO `codeworld_area` VALUES (522623, '施秉县', 522600, 1);
INSERT INTO `codeworld_area` VALUES (522624, '三穗县', 522600, 1);
INSERT INTO `codeworld_area` VALUES (522625, '镇远县', 522600, 1);
INSERT INTO `codeworld_area` VALUES (522626, '岑巩县', 522600, 1);
INSERT INTO `codeworld_area` VALUES (522627, '天柱县', 522600, 1);
INSERT INTO `codeworld_area` VALUES (522628, '锦屏县', 522600, 1);
INSERT INTO `codeworld_area` VALUES (522629, '剑河县', 522600, 1);
INSERT INTO `codeworld_area` VALUES (522630, '台江县', 522600, 1);
INSERT INTO `codeworld_area` VALUES (522631, '黎平县', 522600, 1);
INSERT INTO `codeworld_area` VALUES (522632, '榕江县', 522600, 1);
INSERT INTO `codeworld_area` VALUES (522633, '从江县', 522600, 1);
INSERT INTO `codeworld_area` VALUES (522634, '雷山县', 522600, 1);
INSERT INTO `codeworld_area` VALUES (522635, '麻江县', 522600, 1);
INSERT INTO `codeworld_area` VALUES (522636, '丹寨县', 522600, 1);
INSERT INTO `codeworld_area` VALUES (522700, '黔南布依族苗族自治州', 520000, 1);
INSERT INTO `codeworld_area` VALUES (522701, '都匀市', 522700, 1);
INSERT INTO `codeworld_area` VALUES (522702, '福泉市', 522700, 1);
INSERT INTO `codeworld_area` VALUES (522722, '荔波县', 522700, 1);
INSERT INTO `codeworld_area` VALUES (522723, '贵定县', 522700, 1);
INSERT INTO `codeworld_area` VALUES (522725, '瓮安县', 522700, 1);
INSERT INTO `codeworld_area` VALUES (522726, '独山县', 522700, 1);
INSERT INTO `codeworld_area` VALUES (522727, '平塘县', 522700, 1);
INSERT INTO `codeworld_area` VALUES (522728, '罗甸县', 522700, 1);
INSERT INTO `codeworld_area` VALUES (522729, '长顺县', 522700, 1);
INSERT INTO `codeworld_area` VALUES (522730, '龙里县', 522700, 1);
INSERT INTO `codeworld_area` VALUES (522731, '惠水县', 522700, 1);
INSERT INTO `codeworld_area` VALUES (522732, '三都水族自治县', 522700, 1);
INSERT INTO `codeworld_area` VALUES (530000, '云南省', 0, 1);
INSERT INTO `codeworld_area` VALUES (530100, '昆明市', 530000, 1);
INSERT INTO `codeworld_area` VALUES (530101, '市辖区', 530100, 1);
INSERT INTO `codeworld_area` VALUES (530102, '五华区', 530101, 1);
INSERT INTO `codeworld_area` VALUES (530103, '盘龙区', 530101, 1);
INSERT INTO `codeworld_area` VALUES (530111, '官渡区', 530101, 1);
INSERT INTO `codeworld_area` VALUES (530112, '西山区', 530101, 1);
INSERT INTO `codeworld_area` VALUES (530113, '东川区', 530101, 1);
INSERT INTO `codeworld_area` VALUES (530121, '呈贡县', 530100, 1);
INSERT INTO `codeworld_area` VALUES (530122, '晋宁县', 530100, 1);
INSERT INTO `codeworld_area` VALUES (530124, '富民县', 530100, 1);
INSERT INTO `codeworld_area` VALUES (530125, '宜良县', 530100, 1);
INSERT INTO `codeworld_area` VALUES (530126, '石林彝族自治县', 530100, 1);
INSERT INTO `codeworld_area` VALUES (530127, '嵩明县', 530100, 1);
INSERT INTO `codeworld_area` VALUES (530128, '禄劝彝族苗族自治县', 530100, 1);
INSERT INTO `codeworld_area` VALUES (530129, '寻甸回族彝族自治县', 530100, 1);
INSERT INTO `codeworld_area` VALUES (530181, '安宁市', 530100, 1);
INSERT INTO `codeworld_area` VALUES (530300, '曲靖市', 530000, 1);
INSERT INTO `codeworld_area` VALUES (530301, '市辖区', 530300, 1);
INSERT INTO `codeworld_area` VALUES (530302, '麒麟区', 530301, 1);
INSERT INTO `codeworld_area` VALUES (530321, '马龙县', 530300, 1);
INSERT INTO `codeworld_area` VALUES (530322, '陆良县', 530300, 1);
INSERT INTO `codeworld_area` VALUES (530323, '师宗县', 530300, 1);
INSERT INTO `codeworld_area` VALUES (530324, '罗平县', 530300, 1);
INSERT INTO `codeworld_area` VALUES (530325, '富源县', 530300, 1);
INSERT INTO `codeworld_area` VALUES (530326, '会泽县', 530300, 1);
INSERT INTO `codeworld_area` VALUES (530328, '沾益县', 530300, 1);
INSERT INTO `codeworld_area` VALUES (530381, '宣威市', 530300, 1);
INSERT INTO `codeworld_area` VALUES (530400, '玉溪市', 530000, 1);
INSERT INTO `codeworld_area` VALUES (530401, '市辖区', 530400, 1);
INSERT INTO `codeworld_area` VALUES (530402, '红塔区', 530401, 1);
INSERT INTO `codeworld_area` VALUES (530421, '江川县', 530400, 1);
INSERT INTO `codeworld_area` VALUES (530422, '澄江县', 530400, 1);
INSERT INTO `codeworld_area` VALUES (530423, '通海县', 530400, 1);
INSERT INTO `codeworld_area` VALUES (530424, '华宁县', 530400, 1);
INSERT INTO `codeworld_area` VALUES (530425, '易门县', 530400, 1);
INSERT INTO `codeworld_area` VALUES (530426, '峨山彝族自治县', 530400, 1);
INSERT INTO `codeworld_area` VALUES (530427, '新平彝族傣族自治县', 530400, 1);
INSERT INTO `codeworld_area` VALUES (530428, '元江哈尼族彝族傣族自治县', 530400, 1);
INSERT INTO `codeworld_area` VALUES (530500, '保山市', 530000, 1);
INSERT INTO `codeworld_area` VALUES (530501, '市辖区', 530500, 1);
INSERT INTO `codeworld_area` VALUES (530502, '隆阳区', 530500, 1);
INSERT INTO `codeworld_area` VALUES (530521, '施甸县', 530500, 1);
INSERT INTO `codeworld_area` VALUES (530522, '腾冲县', 530500, 1);
INSERT INTO `codeworld_area` VALUES (530523, '龙陵县', 530500, 1);
INSERT INTO `codeworld_area` VALUES (530524, '昌宁县', 530500, 1);
INSERT INTO `codeworld_area` VALUES (530600, '昭通市', 530000, 1);
INSERT INTO `codeworld_area` VALUES (530601, '市辖区', 530600, 1);
INSERT INTO `codeworld_area` VALUES (530602, '昭阳区', 530601, 1);
INSERT INTO `codeworld_area` VALUES (530621, '鲁甸县', 530600, 1);
INSERT INTO `codeworld_area` VALUES (530622, '巧家县', 530600, 1);
INSERT INTO `codeworld_area` VALUES (530623, '盐津县', 530600, 1);
INSERT INTO `codeworld_area` VALUES (530624, '大关县', 530600, 1);
INSERT INTO `codeworld_area` VALUES (530625, '永善县', 530600, 1);
INSERT INTO `codeworld_area` VALUES (530626, '绥江县', 530600, 1);
INSERT INTO `codeworld_area` VALUES (530627, '镇雄县', 530600, 1);
INSERT INTO `codeworld_area` VALUES (530628, '彝良县', 530600, 1);
INSERT INTO `codeworld_area` VALUES (530629, '威信县', 530600, 1);
INSERT INTO `codeworld_area` VALUES (530630, '水富县', 530600, 1);
INSERT INTO `codeworld_area` VALUES (530700, '丽江市', 530000, 1);
INSERT INTO `codeworld_area` VALUES (530701, '市辖区', 530700, 1);
INSERT INTO `codeworld_area` VALUES (530702, '古城区', 530701, 1);
INSERT INTO `codeworld_area` VALUES (530721, '玉龙纳西族自治县', 530700, 1);
INSERT INTO `codeworld_area` VALUES (530722, '永胜县', 530700, 1);
INSERT INTO `codeworld_area` VALUES (530723, '华坪县', 530700, 1);
INSERT INTO `codeworld_area` VALUES (530724, '宁蒗彝族自治县', 530700, 1);
INSERT INTO `codeworld_area` VALUES (530800, '普洱市', 530000, 1);
INSERT INTO `codeworld_area` VALUES (530801, '市辖区', 530800, 1);
INSERT INTO `codeworld_area` VALUES (530802, '翠云区', 530801, 1);
INSERT INTO `codeworld_area` VALUES (530821, '宁洱哈尼族彝族自治县', 530800, 1);
INSERT INTO `codeworld_area` VALUES (530822, '墨江哈尼族自治县', 530800, 1);
INSERT INTO `codeworld_area` VALUES (530823, '景东彝族自治县', 530800, 1);
INSERT INTO `codeworld_area` VALUES (530824, '景谷傣族彝族自治县', 530800, 1);
INSERT INTO `codeworld_area` VALUES (530825, '镇沅彝族哈尼族拉祜族自治县', 530800, 1);
INSERT INTO `codeworld_area` VALUES (530826, '江城哈尼族彝族自治县', 530800, 1);
INSERT INTO `codeworld_area` VALUES (530827, '孟连傣族拉祜族佤族自治县', 530800, 1);
INSERT INTO `codeworld_area` VALUES (530828, '澜沧拉祜族自治县', 530800, 1);
INSERT INTO `codeworld_area` VALUES (530829, '西盟佤族自治县', 530800, 1);
INSERT INTO `codeworld_area` VALUES (530900, '临沧市', 530000, 1);
INSERT INTO `codeworld_area` VALUES (530901, '市辖区', 530900, 1);
INSERT INTO `codeworld_area` VALUES (530902, '临翔区', 530901, 1);
INSERT INTO `codeworld_area` VALUES (530921, '凤庆县', 530900, 1);
INSERT INTO `codeworld_area` VALUES (530922, '云县', 530900, 1);
INSERT INTO `codeworld_area` VALUES (530923, '永德县', 530900, 1);
INSERT INTO `codeworld_area` VALUES (530924, '镇康县', 530900, 1);
INSERT INTO `codeworld_area` VALUES (530925, '双江拉祜族佤族布朗族傣族自治县', 530900, 1);
INSERT INTO `codeworld_area` VALUES (530926, '耿马傣族佤族自治县', 530900, 1);
INSERT INTO `codeworld_area` VALUES (530927, '沧源佤族自治县', 530900, 1);
INSERT INTO `codeworld_area` VALUES (532300, '楚雄彝族自治州', 530000, 1);
INSERT INTO `codeworld_area` VALUES (532301, '楚雄市', 532300, 1);
INSERT INTO `codeworld_area` VALUES (532322, '双柏县', 532300, 1);
INSERT INTO `codeworld_area` VALUES (532323, '牟定县', 532300, 1);
INSERT INTO `codeworld_area` VALUES (532324, '南华县', 532300, 1);
INSERT INTO `codeworld_area` VALUES (532325, '姚安县', 532300, 1);
INSERT INTO `codeworld_area` VALUES (532326, '大姚县', 532300, 1);
INSERT INTO `codeworld_area` VALUES (532327, '永仁县', 532300, 1);
INSERT INTO `codeworld_area` VALUES (532328, '元谋县', 532300, 1);
INSERT INTO `codeworld_area` VALUES (532329, '武定县', 532300, 1);
INSERT INTO `codeworld_area` VALUES (532331, '禄丰县', 532300, 1);
INSERT INTO `codeworld_area` VALUES (532500, '红河哈尼族彝族自治州', 530000, 1);
INSERT INTO `codeworld_area` VALUES (532501, '个旧市', 532500, 1);
INSERT INTO `codeworld_area` VALUES (532502, '开远市', 532500, 1);
INSERT INTO `codeworld_area` VALUES (532522, '蒙自市', 532500, 1);
INSERT INTO `codeworld_area` VALUES (532523, '屏边苗族自治县', 532500, 1);
INSERT INTO `codeworld_area` VALUES (532524, '建水县', 532500, 1);
INSERT INTO `codeworld_area` VALUES (532525, '石屏县', 532500, 1);
INSERT INTO `codeworld_area` VALUES (532526, '弥勒市', 532500, 1);
INSERT INTO `codeworld_area` VALUES (532527, '泸西县', 532500, 1);
INSERT INTO `codeworld_area` VALUES (532528, '元阳县', 532500, 1);
INSERT INTO `codeworld_area` VALUES (532529, '红河县', 532500, 1);
INSERT INTO `codeworld_area` VALUES (532530, '金平苗族瑶族傣族自治县', 532500, 1);
INSERT INTO `codeworld_area` VALUES (532531, '绿春县', 532500, 1);
INSERT INTO `codeworld_area` VALUES (532532, '河口瑶族自治县', 532500, 1);
INSERT INTO `codeworld_area` VALUES (532600, '文山壮族苗族自治州', 530000, 1);
INSERT INTO `codeworld_area` VALUES (532621, '文山市', 532600, 1);
INSERT INTO `codeworld_area` VALUES (532622, '砚山县', 532600, 1);
INSERT INTO `codeworld_area` VALUES (532623, '西畴县', 532600, 1);
INSERT INTO `codeworld_area` VALUES (532624, '麻栗坡县', 532600, 1);
INSERT INTO `codeworld_area` VALUES (532625, '马关县', 532600, 1);
INSERT INTO `codeworld_area` VALUES (532626, '丘北县', 532600, 1);
INSERT INTO `codeworld_area` VALUES (532627, '广南县', 532600, 1);
INSERT INTO `codeworld_area` VALUES (532628, '富宁县', 532600, 1);
INSERT INTO `codeworld_area` VALUES (532800, '西双版纳傣族自治州', 530000, 1);
INSERT INTO `codeworld_area` VALUES (532801, '景洪市', 532800, 1);
INSERT INTO `codeworld_area` VALUES (532822, '勐海县', 532800, 1);
INSERT INTO `codeworld_area` VALUES (532823, '勐腊县', 532800, 1);
INSERT INTO `codeworld_area` VALUES (532900, '大理白族自治州', 530000, 1);
INSERT INTO `codeworld_area` VALUES (532901, '大理市', 532900, 1);
INSERT INTO `codeworld_area` VALUES (532922, '漾濞彝族自治县', 532900, 1);
INSERT INTO `codeworld_area` VALUES (532923, '祥云县', 532900, 1);
INSERT INTO `codeworld_area` VALUES (532924, '宾川县', 532900, 1);
INSERT INTO `codeworld_area` VALUES (532925, '弥渡县', 532900, 1);
INSERT INTO `codeworld_area` VALUES (532926, '南涧彝族自治县', 532900, 1);
INSERT INTO `codeworld_area` VALUES (532927, '巍山彝族回族自治县', 532900, 1);
INSERT INTO `codeworld_area` VALUES (532928, '永平县', 532900, 1);
INSERT INTO `codeworld_area` VALUES (532929, '云龙县', 532900, 1);
INSERT INTO `codeworld_area` VALUES (532930, '洱源县', 532900, 1);
INSERT INTO `codeworld_area` VALUES (532931, '剑川县', 532900, 1);
INSERT INTO `codeworld_area` VALUES (532932, '鹤庆县', 532900, 1);
INSERT INTO `codeworld_area` VALUES (533100, '德宏傣族景颇族自治州', 530000, 1);
INSERT INTO `codeworld_area` VALUES (533102, '瑞丽市', 533100, 1);
INSERT INTO `codeworld_area` VALUES (533103, '潞西市', 533100, 1);
INSERT INTO `codeworld_area` VALUES (533122, '梁河县', 533100, 1);
INSERT INTO `codeworld_area` VALUES (533123, '盈江县', 533100, 1);
INSERT INTO `codeworld_area` VALUES (533124, '陇川县', 533100, 1);
INSERT INTO `codeworld_area` VALUES (533300, '怒江傈僳族自治州', 530000, 1);
INSERT INTO `codeworld_area` VALUES (533321, '泸水县', 533300, 1);
INSERT INTO `codeworld_area` VALUES (533323, '福贡县', 533300, 1);
INSERT INTO `codeworld_area` VALUES (533324, '贡山独龙族怒族自治县', 533300, 1);
INSERT INTO `codeworld_area` VALUES (533325, '兰坪白族普米族自治县', 533300, 1);
INSERT INTO `codeworld_area` VALUES (533400, '迪庆藏族自治州', 530000, 1);
INSERT INTO `codeworld_area` VALUES (533421, '香格里拉县', 533400, 1);
INSERT INTO `codeworld_area` VALUES (533422, '德钦县', 533400, 1);
INSERT INTO `codeworld_area` VALUES (533423, '维西傈僳族自治县', 533400, 1);
INSERT INTO `codeworld_area` VALUES (540000, '西藏自治区', 0, 1);
INSERT INTO `codeworld_area` VALUES (540100, '拉萨市', 540000, 1);
INSERT INTO `codeworld_area` VALUES (540101, '市辖区', 540100, 1);
INSERT INTO `codeworld_area` VALUES (540102, '城关区', 540101, 1);
INSERT INTO `codeworld_area` VALUES (540121, '林周县', 540100, 1);
INSERT INTO `codeworld_area` VALUES (540122, '当雄县', 540100, 1);
INSERT INTO `codeworld_area` VALUES (540123, '尼木县', 540100, 1);
INSERT INTO `codeworld_area` VALUES (540124, '曲水县', 540100, 1);
INSERT INTO `codeworld_area` VALUES (540125, '堆龙德庆县', 540100, 1);
INSERT INTO `codeworld_area` VALUES (540126, '达孜县', 540100, 1);
INSERT INTO `codeworld_area` VALUES (540127, '墨竹工卡县', 540100, 1);
INSERT INTO `codeworld_area` VALUES (542100, '昌都地区', 540000, 1);
INSERT INTO `codeworld_area` VALUES (542121, '昌都县', 542100, 1);
INSERT INTO `codeworld_area` VALUES (542122, '江达县', 542100, 1);
INSERT INTO `codeworld_area` VALUES (542123, '贡觉县', 542100, 1);
INSERT INTO `codeworld_area` VALUES (542124, '类乌齐县', 542100, 1);
INSERT INTO `codeworld_area` VALUES (542125, '丁青县', 542100, 1);
INSERT INTO `codeworld_area` VALUES (542126, '察雅县', 542100, 1);
INSERT INTO `codeworld_area` VALUES (542127, '八宿县', 542100, 1);
INSERT INTO `codeworld_area` VALUES (542128, '左贡县', 542100, 1);
INSERT INTO `codeworld_area` VALUES (542129, '芒康县', 542100, 1);
INSERT INTO `codeworld_area` VALUES (542132, '洛隆县', 542100, 1);
INSERT INTO `codeworld_area` VALUES (542133, '边坝县', 542100, 1);
INSERT INTO `codeworld_area` VALUES (542200, '山南地区', 540000, 1);
INSERT INTO `codeworld_area` VALUES (542221, '乃东县', 542200, 1);
INSERT INTO `codeworld_area` VALUES (542222, '扎囊县', 542200, 1);
INSERT INTO `codeworld_area` VALUES (542223, '贡嘎县', 542200, 1);
INSERT INTO `codeworld_area` VALUES (542224, '桑日县', 542200, 1);
INSERT INTO `codeworld_area` VALUES (542225, '琼结县', 542200, 1);
INSERT INTO `codeworld_area` VALUES (542226, '曲松县', 542200, 1);
INSERT INTO `codeworld_area` VALUES (542227, '措美县', 542200, 1);
INSERT INTO `codeworld_area` VALUES (542228, '洛扎县', 542200, 1);
INSERT INTO `codeworld_area` VALUES (542229, '加查县', 542200, 1);
INSERT INTO `codeworld_area` VALUES (542231, '隆子县', 542200, 1);
INSERT INTO `codeworld_area` VALUES (542232, '错那县', 542200, 1);
INSERT INTO `codeworld_area` VALUES (542233, '浪卡子县', 542200, 1);
INSERT INTO `codeworld_area` VALUES (542300, '日喀则地区', 540000, 1);
INSERT INTO `codeworld_area` VALUES (542301, '日喀则市', 542300, 1);
INSERT INTO `codeworld_area` VALUES (542322, '南木林县', 542300, 1);
INSERT INTO `codeworld_area` VALUES (542323, '江孜县', 542300, 1);
INSERT INTO `codeworld_area` VALUES (542324, '定日县', 542300, 1);
INSERT INTO `codeworld_area` VALUES (542325, '萨迦县', 542300, 1);
INSERT INTO `codeworld_area` VALUES (542326, '拉孜县', 542300, 1);
INSERT INTO `codeworld_area` VALUES (542327, '昂仁县', 542300, 1);
INSERT INTO `codeworld_area` VALUES (542328, '谢通门县', 542300, 1);
INSERT INTO `codeworld_area` VALUES (542329, '白朗县', 542300, 1);
INSERT INTO `codeworld_area` VALUES (542330, '仁布县', 542300, 1);
INSERT INTO `codeworld_area` VALUES (542331, '康马县', 542300, 1);
INSERT INTO `codeworld_area` VALUES (542332, '定结县', 542300, 1);
INSERT INTO `codeworld_area` VALUES (542333, '仲巴县', 542300, 1);
INSERT INTO `codeworld_area` VALUES (542334, '亚东县', 542300, 1);
INSERT INTO `codeworld_area` VALUES (542335, '吉隆县', 542300, 1);
INSERT INTO `codeworld_area` VALUES (542336, '聂拉木县', 542300, 1);
INSERT INTO `codeworld_area` VALUES (542337, '萨嘎县', 542300, 1);
INSERT INTO `codeworld_area` VALUES (542338, '岗巴县', 542300, 1);
INSERT INTO `codeworld_area` VALUES (542400, '那曲地区', 540000, 1);
INSERT INTO `codeworld_area` VALUES (542421, '那曲县', 542400, 1);
INSERT INTO `codeworld_area` VALUES (542422, '嘉黎县', 542400, 1);
INSERT INTO `codeworld_area` VALUES (542423, '比如县', 542400, 1);
INSERT INTO `codeworld_area` VALUES (542424, '聂荣县', 542400, 1);
INSERT INTO `codeworld_area` VALUES (542425, '安多县', 542400, 1);
INSERT INTO `codeworld_area` VALUES (542426, '申扎县', 542400, 1);
INSERT INTO `codeworld_area` VALUES (542427, '索县', 542400, 1);
INSERT INTO `codeworld_area` VALUES (542428, '班戈县', 542400, 1);
INSERT INTO `codeworld_area` VALUES (542429, '巴青县', 542400, 1);
INSERT INTO `codeworld_area` VALUES (542430, '尼玛县', 542400, 1);
INSERT INTO `codeworld_area` VALUES (542500, '阿里地区', 540000, 1);
INSERT INTO `codeworld_area` VALUES (542521, '普兰县', 542500, 1);
INSERT INTO `codeworld_area` VALUES (542522, '札达县', 542500, 1);
INSERT INTO `codeworld_area` VALUES (542523, '噶尔县', 542500, 1);
INSERT INTO `codeworld_area` VALUES (542524, '日土县', 542500, 1);
INSERT INTO `codeworld_area` VALUES (542525, '革吉县', 542500, 1);
INSERT INTO `codeworld_area` VALUES (542526, '改则县', 542500, 1);
INSERT INTO `codeworld_area` VALUES (542527, '措勤县', 542500, 1);
INSERT INTO `codeworld_area` VALUES (542600, '林芝地区', 540000, 1);
INSERT INTO `codeworld_area` VALUES (542621, '林芝县', 542600, 1);
INSERT INTO `codeworld_area` VALUES (542622, '工布江达县', 542600, 1);
INSERT INTO `codeworld_area` VALUES (542623, '米林县', 542600, 1);
INSERT INTO `codeworld_area` VALUES (542624, '墨脱县', 542600, 1);
INSERT INTO `codeworld_area` VALUES (542625, '波密县', 542600, 1);
INSERT INTO `codeworld_area` VALUES (542626, '察隅县', 542600, 1);
INSERT INTO `codeworld_area` VALUES (542627, '朗县', 542600, 1);
INSERT INTO `codeworld_area` VALUES (610000, '陕西省', 0, 1);
INSERT INTO `codeworld_area` VALUES (610100, '西安市', 610000, 1);
INSERT INTO `codeworld_area` VALUES (610101, '长安区', 610100, 1);
INSERT INTO `codeworld_area` VALUES (610102, '新城区', 610100, 1);
INSERT INTO `codeworld_area` VALUES (610103, '碑林区', 610100, 1);
INSERT INTO `codeworld_area` VALUES (610104, '莲湖区', 610100, 1);
INSERT INTO `codeworld_area` VALUES (610111, '灞桥区', 610100, 1);
INSERT INTO `codeworld_area` VALUES (610112, '未央区', 610100, 1);
INSERT INTO `codeworld_area` VALUES (610113, '雁塔区', 610100, 1);
INSERT INTO `codeworld_area` VALUES (610114, '阎良区', 610100, 1);
INSERT INTO `codeworld_area` VALUES (610115, '临潼区', 610100, 1);
INSERT INTO `codeworld_area` VALUES (610122, '蓝田县', 610100, 1);
INSERT INTO `codeworld_area` VALUES (610124, '周至县', 610100, 1);
INSERT INTO `codeworld_area` VALUES (610125, '户县', 610100, 1);
INSERT INTO `codeworld_area` VALUES (610126, '高陵县', 610100, 1);
INSERT INTO `codeworld_area` VALUES (610200, '铜川市', 610000, 1);
INSERT INTO `codeworld_area` VALUES (610201, '市辖区', 610200, 1);
INSERT INTO `codeworld_area` VALUES (610202, '王益区', 610201, 1);
INSERT INTO `codeworld_area` VALUES (610203, '印台区', 610201, 1);
INSERT INTO `codeworld_area` VALUES (610204, '耀州区', 610201, 1);
INSERT INTO `codeworld_area` VALUES (610222, '宜君县', 610200, 1);
INSERT INTO `codeworld_area` VALUES (610300, '宝鸡市', 610000, 1);
INSERT INTO `codeworld_area` VALUES (610301, '市辖区', 610300, 1);
INSERT INTO `codeworld_area` VALUES (610302, '渭滨区', 610301, 1);
INSERT INTO `codeworld_area` VALUES (610303, '金台区', 610301, 1);
INSERT INTO `codeworld_area` VALUES (610304, '陈仓区', 610301, 1);
INSERT INTO `codeworld_area` VALUES (610322, '凤翔县', 610300, 1);
INSERT INTO `codeworld_area` VALUES (610323, '岐山县', 610300, 1);
INSERT INTO `codeworld_area` VALUES (610324, '扶风县', 610300, 1);
INSERT INTO `codeworld_area` VALUES (610326, '眉县', 610300, 1);
INSERT INTO `codeworld_area` VALUES (610327, '陇县', 610300, 1);
INSERT INTO `codeworld_area` VALUES (610328, '千阳县', 610300, 1);
INSERT INTO `codeworld_area` VALUES (610329, '麟游县', 610300, 1);
INSERT INTO `codeworld_area` VALUES (610330, '凤县', 610300, 1);
INSERT INTO `codeworld_area` VALUES (610331, '太白县', 610300, 1);
INSERT INTO `codeworld_area` VALUES (610400, '咸阳市', 610000, 1);
INSERT INTO `codeworld_area` VALUES (610401, '市辖区', 610400, 1);
INSERT INTO `codeworld_area` VALUES (610402, '秦都区', 610401, 1);
INSERT INTO `codeworld_area` VALUES (610404, '渭城区', 610401, 1);
INSERT INTO `codeworld_area` VALUES (610422, '三原县', 610400, 1);
INSERT INTO `codeworld_area` VALUES (610423, '泾阳县', 610400, 1);
INSERT INTO `codeworld_area` VALUES (610424, '乾县', 610400, 1);
INSERT INTO `codeworld_area` VALUES (610425, '礼泉县', 610400, 1);
INSERT INTO `codeworld_area` VALUES (610426, '永寿县', 610400, 1);
INSERT INTO `codeworld_area` VALUES (610427, '彬县', 610400, 1);
INSERT INTO `codeworld_area` VALUES (610428, '长武县', 610400, 1);
INSERT INTO `codeworld_area` VALUES (610429, '旬邑县', 610400, 1);
INSERT INTO `codeworld_area` VALUES (610430, '淳化县', 610400, 1);
INSERT INTO `codeworld_area` VALUES (610431, '武功县', 610400, 1);
INSERT INTO `codeworld_area` VALUES (610481, '兴平市', 610400, 1);
INSERT INTO `codeworld_area` VALUES (610500, '渭南市', 610000, 1);
INSERT INTO `codeworld_area` VALUES (610501, '市辖区', 610500, 1);
INSERT INTO `codeworld_area` VALUES (610502, '临渭区', 610501, 1);
INSERT INTO `codeworld_area` VALUES (610521, '华县', 610500, 1);
INSERT INTO `codeworld_area` VALUES (610522, '潼关县', 610500, 1);
INSERT INTO `codeworld_area` VALUES (610523, '大荔县', 610500, 1);
INSERT INTO `codeworld_area` VALUES (610524, '合阳县', 610500, 1);
INSERT INTO `codeworld_area` VALUES (610525, '澄城县', 610500, 1);
INSERT INTO `codeworld_area` VALUES (610526, '蒲城县', 610500, 1);
INSERT INTO `codeworld_area` VALUES (610527, '白水县', 610500, 1);
INSERT INTO `codeworld_area` VALUES (610528, '富平县', 610500, 1);
INSERT INTO `codeworld_area` VALUES (610581, '韩城市', 610500, 1);
INSERT INTO `codeworld_area` VALUES (610582, '华阴市', 610500, 1);
INSERT INTO `codeworld_area` VALUES (610600, '延安市', 610000, 1);
INSERT INTO `codeworld_area` VALUES (610601, '市辖区', 610600, 1);
INSERT INTO `codeworld_area` VALUES (610602, '宝塔区', 610601, 1);
INSERT INTO `codeworld_area` VALUES (610621, '延长县', 610600, 1);
INSERT INTO `codeworld_area` VALUES (610622, '延川县', 610600, 1);
INSERT INTO `codeworld_area` VALUES (610623, '子长县', 610600, 1);
INSERT INTO `codeworld_area` VALUES (610624, '安塞县', 610600, 1);
INSERT INTO `codeworld_area` VALUES (610625, '志丹县', 610600, 1);
INSERT INTO `codeworld_area` VALUES (610626, '吴起县', 610600, 1);
INSERT INTO `codeworld_area` VALUES (610627, '甘泉县', 610600, 1);
INSERT INTO `codeworld_area` VALUES (610628, '富县', 610600, 1);
INSERT INTO `codeworld_area` VALUES (610629, '洛川县', 610600, 1);
INSERT INTO `codeworld_area` VALUES (610630, '宜川县', 610600, 1);
INSERT INTO `codeworld_area` VALUES (610631, '黄龙县', 610600, 1);
INSERT INTO `codeworld_area` VALUES (610632, '黄陵县', 610600, 1);
INSERT INTO `codeworld_area` VALUES (610700, '汉中市', 610000, 1);
INSERT INTO `codeworld_area` VALUES (610701, '市辖区', 610700, 1);
INSERT INTO `codeworld_area` VALUES (610702, '汉台区', 610701, 1);
INSERT INTO `codeworld_area` VALUES (610721, '南郑县', 610700, 1);
INSERT INTO `codeworld_area` VALUES (610722, '城固县', 610700, 1);
INSERT INTO `codeworld_area` VALUES (610723, '洋县', 610700, 1);
INSERT INTO `codeworld_area` VALUES (610724, '西乡县', 610700, 1);
INSERT INTO `codeworld_area` VALUES (610725, '勉县', 610700, 1);
INSERT INTO `codeworld_area` VALUES (610726, '宁强县', 610700, 1);
INSERT INTO `codeworld_area` VALUES (610727, '略阳县', 610700, 1);
INSERT INTO `codeworld_area` VALUES (610728, '镇巴县', 610700, 1);
INSERT INTO `codeworld_area` VALUES (610729, '留坝县', 610700, 1);
INSERT INTO `codeworld_area` VALUES (610730, '佛坪县', 610700, 1);
INSERT INTO `codeworld_area` VALUES (610800, '榆林市', 610000, 1);
INSERT INTO `codeworld_area` VALUES (610801, '市辖区', 610800, 1);
INSERT INTO `codeworld_area` VALUES (610802, '榆阳区', 610800, 1);
INSERT INTO `codeworld_area` VALUES (610821, '神木县', 610800, 1);
INSERT INTO `codeworld_area` VALUES (610822, '府谷县', 610800, 1);
INSERT INTO `codeworld_area` VALUES (610823, '横山县', 610800, 1);
INSERT INTO `codeworld_area` VALUES (610824, '靖边县', 610800, 1);
INSERT INTO `codeworld_area` VALUES (610825, '定边县', 610800, 1);
INSERT INTO `codeworld_area` VALUES (610826, '绥德县', 610800, 1);
INSERT INTO `codeworld_area` VALUES (610827, '米脂县', 610800, 1);
INSERT INTO `codeworld_area` VALUES (610828, '佳县', 610800, 1);
INSERT INTO `codeworld_area` VALUES (610829, '吴堡县', 610800, 1);
INSERT INTO `codeworld_area` VALUES (610830, '清涧县', 610800, 1);
INSERT INTO `codeworld_area` VALUES (610831, '子洲县', 610800, 1);
INSERT INTO `codeworld_area` VALUES (610900, '安康市', 610000, 1);
INSERT INTO `codeworld_area` VALUES (610901, '市辖区', 610900, 1);
INSERT INTO `codeworld_area` VALUES (610902, '汉滨区', 610901, 1);
INSERT INTO `codeworld_area` VALUES (610921, '汉阴县', 610900, 1);
INSERT INTO `codeworld_area` VALUES (610922, '石泉县', 610900, 1);
INSERT INTO `codeworld_area` VALUES (610923, '宁陕县', 610900, 1);
INSERT INTO `codeworld_area` VALUES (610924, '紫阳县', 610900, 1);
INSERT INTO `codeworld_area` VALUES (610925, '岚皋县', 610900, 1);
INSERT INTO `codeworld_area` VALUES (610926, '平利县', 610900, 1);
INSERT INTO `codeworld_area` VALUES (610927, '镇坪县', 610900, 1);
INSERT INTO `codeworld_area` VALUES (610928, '旬阳县', 610900, 1);
INSERT INTO `codeworld_area` VALUES (610929, '白河县', 610900, 1);
INSERT INTO `codeworld_area` VALUES (611000, '商洛市', 610000, 1);
INSERT INTO `codeworld_area` VALUES (611001, '市辖区', 611000, 1);
INSERT INTO `codeworld_area` VALUES (611002, '商州区', 611001, 1);
INSERT INTO `codeworld_area` VALUES (611021, '洛南县', 611000, 1);
INSERT INTO `codeworld_area` VALUES (611022, '丹凤县', 611000, 1);
INSERT INTO `codeworld_area` VALUES (611023, '商南县', 611000, 1);
INSERT INTO `codeworld_area` VALUES (611024, '山阳县', 611000, 1);
INSERT INTO `codeworld_area` VALUES (611025, '镇安县', 611000, 1);
INSERT INTO `codeworld_area` VALUES (611026, '柞水县', 611000, 1);
INSERT INTO `codeworld_area` VALUES (611100, '杨凌示范区', 610000, 1);
INSERT INTO `codeworld_area` VALUES (611103, '杨凌区', 611100, 1);
INSERT INTO `codeworld_area` VALUES (620000, '甘肃省', 0, 1);
INSERT INTO `codeworld_area` VALUES (620100, '兰州市', 620000, 1);
INSERT INTO `codeworld_area` VALUES (620101, '市辖区', 620100, 1);
INSERT INTO `codeworld_area` VALUES (620102, '城关区', 620101, 1);
INSERT INTO `codeworld_area` VALUES (620103, '七里河区', 620101, 1);
INSERT INTO `codeworld_area` VALUES (620104, '西固区', 620101, 1);
INSERT INTO `codeworld_area` VALUES (620105, '安宁区', 620101, 1);
INSERT INTO `codeworld_area` VALUES (620111, '红古区', 620101, 1);
INSERT INTO `codeworld_area` VALUES (620121, '永登县', 620100, 1);
INSERT INTO `codeworld_area` VALUES (620122, '皋兰县', 620100, 1);
INSERT INTO `codeworld_area` VALUES (620123, '榆中县', 620100, 1);
INSERT INTO `codeworld_area` VALUES (620200, '嘉峪关市', 620000, 1);
INSERT INTO `codeworld_area` VALUES (620201, '市辖区', 620200, 1);
INSERT INTO `codeworld_area` VALUES (620300, '金昌市', 620000, 1);
INSERT INTO `codeworld_area` VALUES (620301, '金川区', 620300, 1);
INSERT INTO `codeworld_area` VALUES (620321, '永昌县', 620300, 1);
INSERT INTO `codeworld_area` VALUES (620400, '白银市', 620000, 1);
INSERT INTO `codeworld_area` VALUES (620401, '市辖区', 620400, 1);
INSERT INTO `codeworld_area` VALUES (620402, '白银区', 620401, 1);
INSERT INTO `codeworld_area` VALUES (620403, '平川区', 620401, 1);
INSERT INTO `codeworld_area` VALUES (620421, '靖远县', 620400, 1);
INSERT INTO `codeworld_area` VALUES (620422, '会宁县', 620400, 1);
INSERT INTO `codeworld_area` VALUES (620423, '景泰县', 620400, 1);
INSERT INTO `codeworld_area` VALUES (620500, '天水市', 620000, 1);
INSERT INTO `codeworld_area` VALUES (620501, '麦积区', 620500, 1);
INSERT INTO `codeworld_area` VALUES (620502, '秦州区', 620500, 1);
INSERT INTO `codeworld_area` VALUES (620521, '清水县', 620500, 1);
INSERT INTO `codeworld_area` VALUES (620522, '秦安县', 620500, 1);
INSERT INTO `codeworld_area` VALUES (620523, '甘谷县', 620500, 1);
INSERT INTO `codeworld_area` VALUES (620524, '武山县', 620500, 1);
INSERT INTO `codeworld_area` VALUES (620525, '张家川回族自治县', 620500, 1);
INSERT INTO `codeworld_area` VALUES (620600, '武威市', 620000, 1);
INSERT INTO `codeworld_area` VALUES (620601, '市辖区', 620600, 1);
INSERT INTO `codeworld_area` VALUES (620602, '凉州区', 620601, 1);
INSERT INTO `codeworld_area` VALUES (620621, '民勤县', 620600, 1);
INSERT INTO `codeworld_area` VALUES (620622, '古浪县', 620600, 1);
INSERT INTO `codeworld_area` VALUES (620623, '天祝藏族自治县', 620600, 1);
INSERT INTO `codeworld_area` VALUES (620700, '张掖市', 620000, 1);
INSERT INTO `codeworld_area` VALUES (620701, '市辖区', 620700, 1);
INSERT INTO `codeworld_area` VALUES (620702, '甘州区', 620701, 1);
INSERT INTO `codeworld_area` VALUES (620721, '肃南裕固族自治县', 620700, 1);
INSERT INTO `codeworld_area` VALUES (620722, '民乐县', 620700, 1);
INSERT INTO `codeworld_area` VALUES (620723, '临泽县', 620700, 1);
INSERT INTO `codeworld_area` VALUES (620724, '高台县', 620700, 1);
INSERT INTO `codeworld_area` VALUES (620725, '山丹县', 620700, 1);
INSERT INTO `codeworld_area` VALUES (620800, '平凉市', 620000, 1);
INSERT INTO `codeworld_area` VALUES (620801, '市辖区', 620800, 1);
INSERT INTO `codeworld_area` VALUES (620802, '崆峒区', 620801, 1);
INSERT INTO `codeworld_area` VALUES (620821, '泾川县', 620800, 1);
INSERT INTO `codeworld_area` VALUES (620822, '灵台县', 620800, 1);
INSERT INTO `codeworld_area` VALUES (620823, '崇信县', 620800, 1);
INSERT INTO `codeworld_area` VALUES (620824, '华亭县', 620800, 1);
INSERT INTO `codeworld_area` VALUES (620825, '庄浪县', 620800, 1);
INSERT INTO `codeworld_area` VALUES (620826, '静宁县', 620800, 1);
INSERT INTO `codeworld_area` VALUES (620900, '酒泉市', 620000, 1);
INSERT INTO `codeworld_area` VALUES (620901, '市辖区', 620900, 1);
INSERT INTO `codeworld_area` VALUES (620902, '肃州区', 620901, 1);
INSERT INTO `codeworld_area` VALUES (620921, '金塔县', 620900, 1);
INSERT INTO `codeworld_area` VALUES (620922, '瓜洲县', 620900, 1);
INSERT INTO `codeworld_area` VALUES (620923, '肃北蒙古族自治县', 620900, 1);
INSERT INTO `codeworld_area` VALUES (620924, '阿克塞哈萨克族自治县', 620900, 1);
INSERT INTO `codeworld_area` VALUES (620981, '玉门市', 620900, 1);
INSERT INTO `codeworld_area` VALUES (620982, '敦煌市', 620900, 1);
INSERT INTO `codeworld_area` VALUES (621000, '庆阳市', 620000, 1);
INSERT INTO `codeworld_area` VALUES (621001, '市辖区', 621000, 1);
INSERT INTO `codeworld_area` VALUES (621002, '西峰区', 621001, 1);
INSERT INTO `codeworld_area` VALUES (621021, '庆城县', 621000, 1);
INSERT INTO `codeworld_area` VALUES (621022, '环县', 621000, 1);
INSERT INTO `codeworld_area` VALUES (621023, '华池县', 621000, 1);
INSERT INTO `codeworld_area` VALUES (621024, '合水县', 621000, 1);
INSERT INTO `codeworld_area` VALUES (621025, '正宁县', 621000, 1);
INSERT INTO `codeworld_area` VALUES (621026, '宁县', 621000, 1);
INSERT INTO `codeworld_area` VALUES (621027, '镇原县', 621000, 1);
INSERT INTO `codeworld_area` VALUES (621100, '定西市', 620000, 1);
INSERT INTO `codeworld_area` VALUES (621101, '市辖区', 621100, 1);
INSERT INTO `codeworld_area` VALUES (621102, '安定区', 621101, 1);
INSERT INTO `codeworld_area` VALUES (621121, '通渭县', 621100, 1);
INSERT INTO `codeworld_area` VALUES (621122, '陇西县', 621100, 1);
INSERT INTO `codeworld_area` VALUES (621123, '渭源县', 621100, 1);
INSERT INTO `codeworld_area` VALUES (621124, '临洮县', 621100, 1);
INSERT INTO `codeworld_area` VALUES (621125, '漳县', 621100, 1);
INSERT INTO `codeworld_area` VALUES (621126, '岷县', 621100, 1);
INSERT INTO `codeworld_area` VALUES (621200, '陇南市', 620000, 1);
INSERT INTO `codeworld_area` VALUES (621201, '武都区', 621200, 1);
INSERT INTO `codeworld_area` VALUES (621221, '成县', 621200, 1);
INSERT INTO `codeworld_area` VALUES (621222, '文县', 621200, 1);
INSERT INTO `codeworld_area` VALUES (621223, '宕昌县', 621200, 1);
INSERT INTO `codeworld_area` VALUES (621224, '康县', 621200, 1);
INSERT INTO `codeworld_area` VALUES (621225, '西和县', 621200, 1);
INSERT INTO `codeworld_area` VALUES (621226, '礼县', 621200, 1);
INSERT INTO `codeworld_area` VALUES (621227, '徽县', 621200, 1);
INSERT INTO `codeworld_area` VALUES (621228, '两当县', 621200, 1);
INSERT INTO `codeworld_area` VALUES (622900, '临夏回族自治州', 620000, 1);
INSERT INTO `codeworld_area` VALUES (622901, '临夏市', 622900, 1);
INSERT INTO `codeworld_area` VALUES (622921, '临夏县', 622900, 1);
INSERT INTO `codeworld_area` VALUES (622922, '康乐县', 622900, 1);
INSERT INTO `codeworld_area` VALUES (622923, '永靖县', 622900, 1);
INSERT INTO `codeworld_area` VALUES (622924, '广河县', 622900, 1);
INSERT INTO `codeworld_area` VALUES (622925, '和政县', 622900, 1);
INSERT INTO `codeworld_area` VALUES (622926, '东乡族自治县', 622900, 1);
INSERT INTO `codeworld_area` VALUES (622927, '积石山保安族东乡族撒拉族自治县', 622900, 1);
INSERT INTO `codeworld_area` VALUES (623000, '甘南藏族自治州', 620000, 1);
INSERT INTO `codeworld_area` VALUES (623001, '合作市', 623000, 1);
INSERT INTO `codeworld_area` VALUES (623021, '临潭县', 623000, 1);
INSERT INTO `codeworld_area` VALUES (623022, '卓尼县', 623000, 1);
INSERT INTO `codeworld_area` VALUES (623023, '舟曲县', 623000, 1);
INSERT INTO `codeworld_area` VALUES (623024, '迭部县', 623000, 1);
INSERT INTO `codeworld_area` VALUES (623025, '玛曲县', 623000, 1);
INSERT INTO `codeworld_area` VALUES (623026, '碌曲县', 623000, 1);
INSERT INTO `codeworld_area` VALUES (623027, '夏河县', 623000, 1);
INSERT INTO `codeworld_area` VALUES (630000, '青海省', 0, 1);
INSERT INTO `codeworld_area` VALUES (630100, '西宁市', 630000, 1);
INSERT INTO `codeworld_area` VALUES (630101, '市辖区', 630100, 1);
INSERT INTO `codeworld_area` VALUES (630102, '城东区', 630101, 1);
INSERT INTO `codeworld_area` VALUES (630103, '城中区', 630101, 1);
INSERT INTO `codeworld_area` VALUES (630104, '城西区', 630101, 1);
INSERT INTO `codeworld_area` VALUES (630105, '城北区', 630101, 1);
INSERT INTO `codeworld_area` VALUES (630121, '大通回族土族自治县', 630100, 1);
INSERT INTO `codeworld_area` VALUES (630122, '湟中县', 630100, 1);
INSERT INTO `codeworld_area` VALUES (630123, '湟源县', 630100, 1);
INSERT INTO `codeworld_area` VALUES (632100, '海东市', 630000, 1);
INSERT INTO `codeworld_area` VALUES (632121, '平安县', 632100, 1);
INSERT INTO `codeworld_area` VALUES (632122, '民和回族土族自治县', 632100, 1);
INSERT INTO `codeworld_area` VALUES (632123, '乐都区', 632100, 1);
INSERT INTO `codeworld_area` VALUES (632126, '互助土族自治县', 632100, 1);
INSERT INTO `codeworld_area` VALUES (632127, '化隆回族自治县', 632100, 1);
INSERT INTO `codeworld_area` VALUES (632128, '循化撒拉族自治县', 632100, 1);
INSERT INTO `codeworld_area` VALUES (632200, '海北藏族自治州', 630000, 1);
INSERT INTO `codeworld_area` VALUES (632221, '门源回族自治县', 632200, 1);
INSERT INTO `codeworld_area` VALUES (632222, '祁连县', 632200, 1);
INSERT INTO `codeworld_area` VALUES (632223, '海晏县', 632200, 1);
INSERT INTO `codeworld_area` VALUES (632224, '刚察县', 632200, 1);
INSERT INTO `codeworld_area` VALUES (632300, '黄南藏族自治州', 630000, 1);
INSERT INTO `codeworld_area` VALUES (632321, '同仁县', 632300, 1);
INSERT INTO `codeworld_area` VALUES (632322, '尖扎县', 632300, 1);
INSERT INTO `codeworld_area` VALUES (632323, '泽库县', 632300, 1);
INSERT INTO `codeworld_area` VALUES (632324, '河南蒙古族自治县', 632300, 1);
INSERT INTO `codeworld_area` VALUES (632500, '海南藏族自治州', 630000, 1);
INSERT INTO `codeworld_area` VALUES (632521, '共和县', 632500, 1);
INSERT INTO `codeworld_area` VALUES (632522, '同德县', 632500, 1);
INSERT INTO `codeworld_area` VALUES (632523, '贵德县', 632500, 1);
INSERT INTO `codeworld_area` VALUES (632524, '兴海县', 632500, 1);
INSERT INTO `codeworld_area` VALUES (632525, '贵南县', 632500, 1);
INSERT INTO `codeworld_area` VALUES (632600, '果洛藏族自治州', 630000, 1);
INSERT INTO `codeworld_area` VALUES (632621, '玛沁县', 632600, 1);
INSERT INTO `codeworld_area` VALUES (632622, '班玛县', 632600, 1);
INSERT INTO `codeworld_area` VALUES (632623, '甘德县', 632600, 1);
INSERT INTO `codeworld_area` VALUES (632624, '达日县', 632600, 1);
INSERT INTO `codeworld_area` VALUES (632625, '久治县', 632600, 1);
INSERT INTO `codeworld_area` VALUES (632626, '玛多县', 632600, 1);
INSERT INTO `codeworld_area` VALUES (632700, '玉树藏族自治州', 630000, 1);
INSERT INTO `codeworld_area` VALUES (632721, '玉树县', 632700, 1);
INSERT INTO `codeworld_area` VALUES (632722, '杂多县', 632700, 1);
INSERT INTO `codeworld_area` VALUES (632723, '称多县', 632700, 1);
INSERT INTO `codeworld_area` VALUES (632724, '治多县', 632700, 1);
INSERT INTO `codeworld_area` VALUES (632725, '囊谦县', 632700, 1);
INSERT INTO `codeworld_area` VALUES (632726, '曲麻莱县', 632700, 1);
INSERT INTO `codeworld_area` VALUES (632800, '海西蒙古族藏族自治州', 630000, 1);
INSERT INTO `codeworld_area` VALUES (632801, '格尔木市', 632800, 1);
INSERT INTO `codeworld_area` VALUES (632802, '德令哈市', 632800, 1);
INSERT INTO `codeworld_area` VALUES (632821, '乌兰县', 632800, 1);
INSERT INTO `codeworld_area` VALUES (632822, '都兰县', 632800, 1);
INSERT INTO `codeworld_area` VALUES (632823, '天峻县', 632800, 1);
INSERT INTO `codeworld_area` VALUES (640000, '宁夏回族自治区', 0, 1);
INSERT INTO `codeworld_area` VALUES (640100, '银川市', 640000, 1);
INSERT INTO `codeworld_area` VALUES (640104, '兴庆区', 640100, 1);
INSERT INTO `codeworld_area` VALUES (640105, '西夏区', 640100, 1);
INSERT INTO `codeworld_area` VALUES (640106, '金凤区', 640100, 1);
INSERT INTO `codeworld_area` VALUES (640121, '永宁县', 640100, 1);
INSERT INTO `codeworld_area` VALUES (640122, '贺兰县', 640100, 1);
INSERT INTO `codeworld_area` VALUES (640181, '灵武市', 640100, 1);
INSERT INTO `codeworld_area` VALUES (640200, '石嘴山市', 640000, 1);
INSERT INTO `codeworld_area` VALUES (640202, '大武口区', 640200, 1);
INSERT INTO `codeworld_area` VALUES (640205, '惠农县', 640200, 1);
INSERT INTO `codeworld_area` VALUES (640221, '平罗县', 640200, 1);
INSERT INTO `codeworld_area` VALUES (640300, '吴忠市', 640000, 1);
INSERT INTO `codeworld_area` VALUES (640301, '红寺堡区', 640300, 1);
INSERT INTO `codeworld_area` VALUES (640302, '利通区', 640300, 1);
INSERT INTO `codeworld_area` VALUES (640323, '盐池县', 640300, 1);
INSERT INTO `codeworld_area` VALUES (640324, '同心县', 640300, 1);
INSERT INTO `codeworld_area` VALUES (640381, '青铜峡市', 640300, 1);
INSERT INTO `codeworld_area` VALUES (640400, '固原市', 640000, 1);
INSERT INTO `codeworld_area` VALUES (640401, '市辖区', 640400, 1);
INSERT INTO `codeworld_area` VALUES (640402, '原州区', 640400, 1);
INSERT INTO `codeworld_area` VALUES (640422, '西吉县', 640400, 1);
INSERT INTO `codeworld_area` VALUES (640423, '隆德县', 640400, 1);
INSERT INTO `codeworld_area` VALUES (640424, '泾源县', 640400, 1);
INSERT INTO `codeworld_area` VALUES (640425, '彭阳县', 640400, 1);
INSERT INTO `codeworld_area` VALUES (640500, '中卫市', 640000, 1);
INSERT INTO `codeworld_area` VALUES (640501, '市辖区', 640500, 1);
INSERT INTO `codeworld_area` VALUES (640502, '沙坡头区', 640500, 1);
INSERT INTO `codeworld_area` VALUES (640521, '中宁县', 640500, 1);
INSERT INTO `codeworld_area` VALUES (640522, '海原县', 640500, 1);
INSERT INTO `codeworld_area` VALUES (650000, '新疆维吾尔自治区', 0, 1);
INSERT INTO `codeworld_area` VALUES (650100, '乌鲁木齐市', 650000, 1);
INSERT INTO `codeworld_area` VALUES (650101, '市辖区', 650100, 1);
INSERT INTO `codeworld_area` VALUES (650102, '天山区', 650101, 1);
INSERT INTO `codeworld_area` VALUES (650103, '沙依巴克区', 650101, 1);
INSERT INTO `codeworld_area` VALUES (650104, '新市区', 650101, 1);
INSERT INTO `codeworld_area` VALUES (650105, '水磨沟区', 650101, 1);
INSERT INTO `codeworld_area` VALUES (650106, '头屯河区', 650101, 1);
INSERT INTO `codeworld_area` VALUES (650107, '达坂城区', 650101, 1);
INSERT INTO `codeworld_area` VALUES (650108, '东山区', 650101, 1);
INSERT INTO `codeworld_area` VALUES (650121, '乌鲁木齐县', 650100, 1);
INSERT INTO `codeworld_area` VALUES (650200, '克拉玛依市', 650000, 1);
INSERT INTO `codeworld_area` VALUES (650201, '市辖区', 650200, 1);
INSERT INTO `codeworld_area` VALUES (650202, '独山子区', 650201, 1);
INSERT INTO `codeworld_area` VALUES (650203, '克拉玛依区', 650201, 1);
INSERT INTO `codeworld_area` VALUES (650204, '白碱滩区', 650201, 1);
INSERT INTO `codeworld_area` VALUES (650205, '乌尔禾区', 650201, 1);
INSERT INTO `codeworld_area` VALUES (652100, '吐鲁番地区', 650000, 1);
INSERT INTO `codeworld_area` VALUES (652101, '吐鲁番市', 652100, 1);
INSERT INTO `codeworld_area` VALUES (652122, '鄯善县', 652100, 1);
INSERT INTO `codeworld_area` VALUES (652123, '托克逊县', 652100, 1);
INSERT INTO `codeworld_area` VALUES (652200, '哈密地区', 650000, 1);
INSERT INTO `codeworld_area` VALUES (652201, '哈密市', 652200, 1);
INSERT INTO `codeworld_area` VALUES (652222, '巴里坤哈萨克自治县', 652200, 1);
INSERT INTO `codeworld_area` VALUES (652223, '伊吾县', 652200, 1);
INSERT INTO `codeworld_area` VALUES (652300, '昌吉回族自治州', 650000, 1);
INSERT INTO `codeworld_area` VALUES (652301, '昌吉市', 652300, 1);
INSERT INTO `codeworld_area` VALUES (652302, '阜康市', 652300, 1);
INSERT INTO `codeworld_area` VALUES (652303, '米泉市', 652300, 1);
INSERT INTO `codeworld_area` VALUES (652323, '呼图壁县', 652300, 1);
INSERT INTO `codeworld_area` VALUES (652324, '玛纳斯县', 652300, 1);
INSERT INTO `codeworld_area` VALUES (652325, '奇台县', 652300, 1);
INSERT INTO `codeworld_area` VALUES (652327, '吉木萨尔县', 652300, 1);
INSERT INTO `codeworld_area` VALUES (652328, '木垒哈萨克自治县', 652300, 1);
INSERT INTO `codeworld_area` VALUES (652700, '博尔塔拉蒙古自治州', 650000, 1);
INSERT INTO `codeworld_area` VALUES (652701, '博乐市', 652700, 1);
INSERT INTO `codeworld_area` VALUES (652722, '精河县', 652700, 1);
INSERT INTO `codeworld_area` VALUES (652723, '温泉县', 652700, 1);
INSERT INTO `codeworld_area` VALUES (652800, '巴音郭楞蒙古自治州', 650000, 1);
INSERT INTO `codeworld_area` VALUES (652801, '库尔勒市', 652800, 1);
INSERT INTO `codeworld_area` VALUES (652822, '轮台县', 652800, 1);
INSERT INTO `codeworld_area` VALUES (652823, '尉犁县', 652800, 1);
INSERT INTO `codeworld_area` VALUES (652824, '若羌县', 652800, 1);
INSERT INTO `codeworld_area` VALUES (652825, '且末县', 652800, 1);
INSERT INTO `codeworld_area` VALUES (652826, '焉耆回族自治县', 652800, 1);
INSERT INTO `codeworld_area` VALUES (652827, '和静县', 652800, 1);
INSERT INTO `codeworld_area` VALUES (652828, '和硕县', 652800, 1);
INSERT INTO `codeworld_area` VALUES (652829, '博湖县', 652800, 1);
INSERT INTO `codeworld_area` VALUES (652900, '阿克苏地区', 650000, 1);
INSERT INTO `codeworld_area` VALUES (652901, '阿克苏市', 652900, 1);
INSERT INTO `codeworld_area` VALUES (652922, '温宿县', 652900, 1);
INSERT INTO `codeworld_area` VALUES (652923, '库车县', 652900, 1);
INSERT INTO `codeworld_area` VALUES (652924, '沙雅县', 652900, 1);
INSERT INTO `codeworld_area` VALUES (652925, '新和县', 652900, 1);
INSERT INTO `codeworld_area` VALUES (652926, '拜城县', 652900, 1);
INSERT INTO `codeworld_area` VALUES (652927, '乌什县', 652900, 1);
INSERT INTO `codeworld_area` VALUES (652928, '阿瓦提县', 652900, 1);
INSERT INTO `codeworld_area` VALUES (652929, '柯坪县', 652900, 1);
INSERT INTO `codeworld_area` VALUES (653000, '克孜勒苏柯尔克孜自治州', 650000, 1);
INSERT INTO `codeworld_area` VALUES (653001, '阿图什市', 653000, 1);
INSERT INTO `codeworld_area` VALUES (653022, '阿克陶县', 653000, 1);
INSERT INTO `codeworld_area` VALUES (653023, '阿合奇县', 653000, 1);
INSERT INTO `codeworld_area` VALUES (653024, '乌恰县', 653000, 1);
INSERT INTO `codeworld_area` VALUES (653100, '喀什地区', 650000, 1);
INSERT INTO `codeworld_area` VALUES (653101, '喀什市', 653100, 1);
INSERT INTO `codeworld_area` VALUES (653121, '疏附县', 653100, 1);
INSERT INTO `codeworld_area` VALUES (653122, '疏勒县', 653100, 1);
INSERT INTO `codeworld_area` VALUES (653123, '英吉沙县', 653100, 1);
INSERT INTO `codeworld_area` VALUES (653124, '泽普县', 653100, 1);
INSERT INTO `codeworld_area` VALUES (653125, '莎车县', 653100, 1);
INSERT INTO `codeworld_area` VALUES (653126, '叶城县', 653100, 1);
INSERT INTO `codeworld_area` VALUES (653127, '麦盖提县', 653100, 1);
INSERT INTO `codeworld_area` VALUES (653128, '岳普湖县', 653100, 1);
INSERT INTO `codeworld_area` VALUES (653129, '伽师县', 653100, 1);
INSERT INTO `codeworld_area` VALUES (653130, '巴楚县', 653100, 1);
INSERT INTO `codeworld_area` VALUES (653131, '塔什库尔干塔吉克自治县', 653100, 1);
INSERT INTO `codeworld_area` VALUES (653200, '和田地区', 650000, 1);
INSERT INTO `codeworld_area` VALUES (653201, '和田市', 653200, 1);
INSERT INTO `codeworld_area` VALUES (653221, '和田县', 653200, 1);
INSERT INTO `codeworld_area` VALUES (653222, '墨玉县', 653200, 1);
INSERT INTO `codeworld_area` VALUES (653223, '皮山县', 653200, 1);
INSERT INTO `codeworld_area` VALUES (653224, '洛浦县', 653200, 1);
INSERT INTO `codeworld_area` VALUES (653225, '策勒县', 653200, 1);
INSERT INTO `codeworld_area` VALUES (653226, '于田县', 653200, 1);
INSERT INTO `codeworld_area` VALUES (653227, '民丰县', 653200, 1);
INSERT INTO `codeworld_area` VALUES (654000, '伊犁哈萨克自治州', 650000, 1);
INSERT INTO `codeworld_area` VALUES (654002, '伊宁市', 654000, 1);
INSERT INTO `codeworld_area` VALUES (654003, '奎屯市', 654000, 1);
INSERT INTO `codeworld_area` VALUES (654021, '伊宁县', 654000, 1);
INSERT INTO `codeworld_area` VALUES (654022, '察布查尔锡伯自治县', 654000, 1);
INSERT INTO `codeworld_area` VALUES (654023, '霍城县', 654000, 1);
INSERT INTO `codeworld_area` VALUES (654024, '巩留县', 654000, 1);
INSERT INTO `codeworld_area` VALUES (654025, '新源县', 654000, 1);
INSERT INTO `codeworld_area` VALUES (654026, '昭苏县', 654000, 1);
INSERT INTO `codeworld_area` VALUES (654027, '特克斯县', 654000, 1);
INSERT INTO `codeworld_area` VALUES (654028, '尼勒克县', 654000, 1);
INSERT INTO `codeworld_area` VALUES (654200, '塔城地区', 650000, 1);
INSERT INTO `codeworld_area` VALUES (654201, '塔城市', 654200, 1);
INSERT INTO `codeworld_area` VALUES (654202, '乌苏市', 654200, 1);
INSERT INTO `codeworld_area` VALUES (654221, '额敏县', 654200, 1);
INSERT INTO `codeworld_area` VALUES (654223, '沙湾县', 654200, 1);
INSERT INTO `codeworld_area` VALUES (654224, '托里县', 654200, 1);
INSERT INTO `codeworld_area` VALUES (654225, '裕民县', 654200, 1);
INSERT INTO `codeworld_area` VALUES (654226, '和布克赛尔蒙古自治县', 654200, 1);
INSERT INTO `codeworld_area` VALUES (654300, '阿勒泰地区', 650000, 1);
INSERT INTO `codeworld_area` VALUES (654301, '阿勒泰市', 654300, 1);
INSERT INTO `codeworld_area` VALUES (654321, '布尔津县', 654300, 1);
INSERT INTO `codeworld_area` VALUES (654322, '富蕴县', 654300, 1);
INSERT INTO `codeworld_area` VALUES (654323, '福海县', 654300, 1);
INSERT INTO `codeworld_area` VALUES (654324, '哈巴河县', 654300, 1);
INSERT INTO `codeworld_area` VALUES (654325, '青河县', 654300, 1);
INSERT INTO `codeworld_area` VALUES (654326, '吉木乃县', 654300, 1);
INSERT INTO `codeworld_area` VALUES (659000, '省直辖行政单位', 650000, 1);
INSERT INTO `codeworld_area` VALUES (659001, '石河子市', 659000, 1);
INSERT INTO `codeworld_area` VALUES (659002, '阿拉尔市', 659000, 1);
INSERT INTO `codeworld_area` VALUES (659003, '图木舒克市', 659000, 1);
INSERT INTO `codeworld_area` VALUES (659004, '五家渠市', 659000, 1);
INSERT INTO `codeworld_area` VALUES (990000, '新疆建设兵团', 0, 1);
INSERT INTO `codeworld_area` VALUES (990100, '第一师', 990000, 1);
INSERT INTO `codeworld_area` VALUES (990200, '第二师', 990000, 1);
INSERT INTO `codeworld_area` VALUES (990300, '第三师', 990000, 1);
INSERT INTO `codeworld_area` VALUES (990400, '第四师', 990000, 1);
INSERT INTO `codeworld_area` VALUES (990500, '第五师', 990000, 1);
INSERT INTO `codeworld_area` VALUES (990600, '第六师', 990000, 1);
INSERT INTO `codeworld_area` VALUES (990700, '第七师', 990000, 1);
INSERT INTO `codeworld_area` VALUES (990800, '第八师', 990000, 1);
INSERT INTO `codeworld_area` VALUES (990900, '第九师', 990000, 1);
INSERT INTO `codeworld_area` VALUES (991000, '第十师', 990000, 1);
INSERT INTO `codeworld_area` VALUES (991100, '建工师', 990000, 1);
INSERT INTO `codeworld_area` VALUES (991200, '第十二师', 990000, 1);
INSERT INTO `codeworld_area` VALUES (991300, '第十三师', 990000, 1);
INSERT INTO `codeworld_area` VALUES (991400, '第十四师', 990000, 1);

-- ----------------------------
-- Table structure for codeworld_attribute
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_attribute`;
CREATE TABLE `codeworld_attribute`  (
  `t_attribute_id` bigint(20) NOT NULL COMMENT '属性主键Id',
  `t_attribute_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性名称',
  `t_category_id` bigint(20) NULL DEFAULT NULL COMMENT '分类Id',
  `t_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_attribute_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_attribute
-- ----------------------------
INSERT INTO `codeworld_attribute` VALUES (225185, '主体', 500117, '2020-12-18 10:31:03', '2020-12-18 10:31:03');
INSERT INTO `codeworld_attribute` VALUES (513162, '基本信息', 500117, '2020-12-18 10:31:03', '2020-12-18 10:31:03');
INSERT INTO `codeworld_attribute` VALUES (709554, '基本信息', 500117, '2020-12-18 10:30:57', '2020-12-18 10:30:57');

-- ----------------------------
-- Table structure for codeworld_carouse
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_carouse`;
CREATE TABLE `codeworld_carouse`  (
  `t_carouse_id` bigint(20) NOT NULL COMMENT '轮播图Id',
  `t_carouse_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '轮播图标题',
  `t_carouse_image` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '轮播图图片',
  `t_carouse_status` int(1) NULL DEFAULT NULL COMMENT '轮播图状态 1--启用 2--未启用  0--过期 -1--删除',
  `t_carouse_start_time` datetime(0) NULL DEFAULT NULL COMMENT '轮播图开始时间',
  `t_carouse_end_time` datetime(0) NULL DEFAULT NULL COMMENT '轮播图结束时间',
  `t_carouse_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_carouse_review_status` int(1) NULL DEFAULT NULL COMMENT '审核状态 0-未审核 1--审核通过 -1--未通过',
  `t_carouse_position` int(255) NULL DEFAULT NULL COMMENT '轮播图位置 1--app首页 2--店铺中',
  `t_merchant_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户号',
  PRIMARY KEY (`t_carouse_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_carouse
-- ----------------------------
INSERT INTO `codeworld_carouse` VALUES (551681, '小米11', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/24/45441614138494427.jpg', -1, '2021-02-24 11:50:38', '2021-02-24 11:55:49', NULL, NULL, NULL, NULL);
INSERT INTO `codeworld_carouse` VALUES (862953, '红米K40 12+256', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/23/27791614065808704.jpg', -1, '2021-02-23 15:40:23', '2021-02-23 15:45:32', NULL, NULL, NULL, NULL);
INSERT INTO `codeworld_carouse` VALUES (895851, '华为MX2', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/24/94421614158841531.jpg', -1, '2021-02-24 17:30:47', '2021-02-24 17:31:59', '2021-02-24 17:27:23', 1, 1, '21181611095746339');
INSERT INTO `codeworld_carouse` VALUES (976108, '小米MIX12', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/24/61471614138920913.png', -1, '2021-02-24 11:55:48', '2021-02-24 11:56:55', '2021-02-24 11:55:23', 1, 1, '21181611095746339');

-- ----------------------------
-- Table structure for codeworld_cart
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_cart`;
CREATE TABLE `codeworld_cart`  (
  `t_cart_id` bigint(20) NOT NULL COMMENT '购物车主键id',
  `t_cart_member_id` bigint(20) NULL DEFAULT NULL COMMENT '会员id',
  `t_cart_product_id` bigint(20) NULL DEFAULT NULL COMMENT '商品id',
  `t_cart_product_sku_id` bigint(20) NULL DEFAULT NULL COMMENT '商品Skuid',
  `t_cart_product_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品标题',
  `t_cart_product_price` int(10) NULL DEFAULT NULL COMMENT '商品价格',
  `t_cart_product_count` int(10) NULL DEFAULT NULL COMMENT '商品数量',
  `t_cart_product_status` int(1) NULL DEFAULT NULL COMMENT '购物车中商品的状态 1--未删除 0--删除',
  `t_cart_product_image` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `t_cart_product_sku` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品Sku',
  `t_cart_merchant_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户编号',
  `t_cart_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_cart_status` int(1) NULL DEFAULT 1 COMMENT '0--删除 1--未删除',
  PRIMARY KEY (`t_cart_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_cart
-- ----------------------------
INSERT INTO `codeworld_cart` VALUES (11103, 838395, 711211, 129735, 'VivoX100 红色 1000G', 1, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\",\"price\":1,\"id\":129735,\"title\":\"VivoX100 红色 1000G\"}', '21181611095746339', '2021-02-04 09:09:18', 0);
INSERT INTO `codeworld_cart` VALUES (62785, 491313, 897175, 189609, '小米MIX2 绿色 20G', 9999, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg\",\"price\":9999,\"id\":189609,\"title\":\"小米MIX2 绿色 20G\"}', '21181608848696318', '2021-02-03 14:59:52', 0);
INSERT INTO `codeworld_cart` VALUES (68344, 838395, 711211, 129735, 'VivoX100 红色 1000G', 1, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\",\"price\":1,\"id\":129735,\"title\":\"VivoX100 红色 1000G\"}', '21181611095746339', '2021-02-03 16:46:56', 0);
INSERT INTO `codeworld_cart` VALUES (92485, 838395, 711211, 129735, 'VivoX100 红色 1000G', 1, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\",\"price\":1,\"id\":129735,\"title\":\"VivoX100 红色 1000G\"}', '21181611095746339', '2021-02-04 15:17:10', 0);
INSERT INTO `codeworld_cart` VALUES (181936, 838395, 711211, 129735, 'VivoX100 红色 1000G', 1, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\",\"price\":1,\"id\":129735,\"title\":\"VivoX100 红色 1000G\"}', '21181611095746339', '2021-01-07 17:18:49', 0);
INSERT INTO `codeworld_cart` VALUES (216613, 838395, 234364, 31914, '小米MIX5 黑色 2000G', 11, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/06/77881612598154251.jpg\",\"price\":11,\"id\":31914,\"title\":\"小米MIX5 黑色 2000G\"}', '21181611095746339', '2021-02-23 17:39:24', 0);
INSERT INTO `codeworld_cart` VALUES (225098, 838395, 897175, 189609, '小米MIX2 绿色 20G', 9999, 1, 1, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg', '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg\",\"price\":9999,\"id\":189609,\"title\":\"小米MIX2 绿色 20G\"}', NULL, '2020-12-27 15:55:54', 0);
INSERT INTO `codeworld_cart` VALUES (228646, 838395, 897175, 189609, '小米MIX2 绿色 20G', 9999, 1, 1, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg', '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg\",\"price\":9999,\"id\":189609,\"title\":\"小米MIX2 绿色 20G\"}', NULL, '2020-12-28 10:39:36', 0);
INSERT INTO `codeworld_cart` VALUES (229182, 838395, 897175, 756668, '小米MIX2 绿色 20G', 99, 1, 1, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg', '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/39601608258814803.jpg\",\"price\":99,\"id\":756668,\"title\":\"小米MIX2 红色 20G\"}', NULL, '2020-12-27 16:22:59', 0);
INSERT INTO `codeworld_cart` VALUES (257928, 838395, 711211, 129735, 'VivoX100 红色 1000G', 1, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\",\"price\":1,\"id\":129735,\"title\":\"VivoX100 红色 1000G\"}', '21181611095746339', '2021-01-07 17:36:45', 0);
INSERT INTO `codeworld_cart` VALUES (292166, 838395, 668339, 86869, 'Iphone20 红色 1000G', 1, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/96101609919575712.jpg\",\"price\":1,\"id\":86869,\"title\":\"Iphone20 红色 1000G\"}', '21181608848696318', '2021-02-04 14:49:01', 0);
INSERT INTO `codeworld_cart` VALUES (370425, 838395, 668339, 86869, 'Iphone20 红色 1000G', 1, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/96101609919575712.jpg\",\"price\":1,\"id\":86869,\"title\":\"Iphone20 红色 1000G\"}', '21181608848696318', '2021-02-05 10:08:19', 0);
INSERT INTO `codeworld_cart` VALUES (432457, 838395, 668339, 86869, 'Iphone20 红色 1000G', 1, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/96101609919575712.jpg\",\"price\":1,\"id\":86869,\"title\":\"Iphone20 红色 1000G\"}', '21181608848696318', '2021-02-04 09:09:21', 0);
INSERT INTO `codeworld_cart` VALUES (450010, 838395, 897175, 189609, '小米MIX2 绿色 20G', 9999, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg\",\"price\":9999,\"id\":189609,\"title\":\"小米MIX2 绿色 20G\"}', '21181608848696318', '2021-02-04 14:49:04', 0);
INSERT INTO `codeworld_cart` VALUES (459285, 838395, 897175, 189609, '小米MIX2 绿色 20G', 9999, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg\",\"price\":9999,\"id\":189609,\"title\":\"小米MIX2 绿色 20G\"}', '21181608848696318', '2021-02-04 10:38:04', 0);
INSERT INTO `codeworld_cart` VALUES (491325, 838395, 668339, 86869, 'Iphone20 红色 1000G', 1, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/96101609919575712.jpg\",\"price\":1,\"id\":86869,\"title\":\"Iphone20 红色 1000G\"}', '21181608848696318', '2021-02-03 16:47:00', 0);
INSERT INTO `codeworld_cart` VALUES (504496, 838395, 711211, 129735, 'VivoX100 红色 1000G', 1, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\",\"price\":1,\"id\":129735,\"title\":\"VivoX100 红色 1000G\"}', '21181611095746339', '2021-02-04 14:48:58', 0);
INSERT INTO `codeworld_cart` VALUES (529036, 838395, 897175, 189609, '小米MIX2 绿色 20G', 9999, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg\",\"price\":9999,\"id\":189609,\"title\":\"小米MIX2 绿色 20G\"}', '21181608848696318', '2021-02-04 09:09:27', 0);
INSERT INTO `codeworld_cart` VALUES (535865, 838395, 897175, 189609, '小米MIX2 绿色 20G', 9999, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg\",\"price\":9999,\"id\":189609,\"title\":\"小米MIX2 绿色 20G\"}', '21181608848696318', '2021-02-04 09:09:26', 0);
INSERT INTO `codeworld_cart` VALUES (594879, 838395, 711211, 129735, 'VivoX100 红色 1000G', 1, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\",\"price\":1,\"id\":129735,\"title\":\"VivoX100 红色 1000G\"}', '21181611095746339', '2021-02-03 16:47:05', 0);
INSERT INTO `codeworld_cart` VALUES (629957, 838395, 668339, 185457, 'Iphone20 绿色 1000G', 3, 1, 1, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/96101609919575712.jpg', '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/58571609919598472.jpg\",\"price\":3,\"id\":185457,\"title\":\"Iphone20 绿色 1000G\"}', '21181608848696318', '2021-01-06 17:03:00', 0);
INSERT INTO `codeworld_cart` VALUES (638965, 491313, 711211, 129735, 'VivoX100 红色 1000G', 1, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\",\"price\":1,\"id\":129735,\"title\":\"VivoX100 红色 1000G\"}', '21181611095746339', '2021-02-03 14:59:46', 0);
INSERT INTO `codeworld_cart` VALUES (647609, 838395, 711211, 129735, 'VivoX100 红色 1000G', 1, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\",\"price\":1,\"id\":129735,\"title\":\"VivoX100 红色 1000G\"}', '21181611095746339', '2021-02-06 15:46:35', 0);
INSERT INTO `codeworld_cart` VALUES (719696, 838395, 897175, 756668, '小米MIX2 绿色 20G', 99, 1, 1, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg', '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/39601608258814803.jpg\",\"price\":99,\"id\":756668,\"title\":\"小米MIX2 红色 20G\"}', NULL, '2020-12-27 15:54:34', 0);
INSERT INTO `codeworld_cart` VALUES (768070, 838395, 234364, 31914, '小米MIX5 黑色 2000G', 11, 3, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/06/77881612598154251.jpg\",\"price\":11,\"id\":31914,\"title\":\"小米MIX5 黑色 2000G\"}', '21181611095746339', '2021-03-09 15:01:37', 1);
INSERT INTO `codeworld_cart` VALUES (800400, 838395, 711211, 129735, 'VivoX100 红色 1000G', 1, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\",\"price\":1,\"id\":129735,\"title\":\"VivoX100 红色 1000G\"}', '21181611095746339', '2021-02-04 17:11:18', 0);
INSERT INTO `codeworld_cart` VALUES (814325, 838395, 897175, 189609, '小米MIX2 绿色 20G', 9999, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg\",\"price\":9999,\"id\":189609,\"title\":\"小米MIX2 绿色 20G\"}', '21181608848696318', '2021-02-04 09:09:24', 0);
INSERT INTO `codeworld_cart` VALUES (873154, 838395, 668339, 86869, 'Iphone20 红色 1000G', 1, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/96101609919575712.jpg\",\"price\":1,\"id\":86869,\"title\":\"Iphone20 红色 1000G\"}', '21181608848696318', '2021-02-03 16:47:03', 0);
INSERT INTO `codeworld_cart` VALUES (893254, 838395, 711211, 129735, 'VivoX100 红色 1000G', 1, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\",\"price\":1,\"id\":129735,\"title\":\"VivoX100 红色 1000G\"}', '21181611095746339', '2021-02-04 15:37:56', 0);
INSERT INTO `codeworld_cart` VALUES (947149, 838395, 711211, 129735, 'VivoX100 红色 1000G', 1, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\",\"price\":1,\"id\":129735,\"title\":\"VivoX100 红色 1000G\"}', '21181611095746339', '2021-02-05 10:08:14', 0);
INSERT INTO `codeworld_cart` VALUES (986650, 838395, 711211, 129735, 'VivoX100 红色 1000G', 1, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\",\"price\":1,\"id\":129735,\"title\":\"VivoX100 红色 1000G\"}', '21181611095746339', '2021-02-04 10:38:01', 0);

-- ----------------------------
-- Table structure for codeworld_category
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_category`;
CREATE TABLE `codeworld_category`  (
  `t_category_id` bigint(20) NOT NULL COMMENT '分类主键Id',
  `t_category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `t_category_parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父级Id',
  `t_category_sort_no` int(10) NULL DEFAULT NULL COMMENT '排序',
  `t_category_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类类型',
  `t_category_image` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类图片',
  `t_category_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_category_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_category_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_category
-- ----------------------------
INSERT INTO `codeworld_category` VALUES (45623, '礼品鲜花', 0, 1, 'menu', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/17/23201608200053876.jpg', '2020-12-17 18:14:23', '2020-12-17 18:14:23');
INSERT INTO `codeworld_category` VALUES (279618, '礼品', 45623, 1, 'button', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/17/25161608200181837.jpg', '2020-12-17 18:16:28', '2021-01-20 15:29:27');
INSERT INTO `codeworld_category` VALUES (500117, '运营商', 863188, 2, 'button', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/17/42261608199892187.jpg', '2020-12-17 18:11:44', '2021-01-20 15:31:06');
INSERT INTO `codeworld_category` VALUES (843201, '手机通信', 863188, 1, 'button', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/17/28481608199773295.jpg', '2020-12-17 18:09:40', '2021-01-20 15:31:02');
INSERT INTO `codeworld_category` VALUES (863188, '手机数码', 0, 1, 'menu', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/17/81721608199750719.jpg', '2020-12-17 18:09:17', '2020-12-17 18:09:17');
INSERT INTO `codeworld_category` VALUES (944899, '鲜花', 45623, 2, 'button', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/17/48561608200240683.jpg', '2020-12-17 18:17:27', '2021-01-20 15:29:53');

-- ----------------------------
-- Table structure for codeworld_category_attribute
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_category_attribute`;
CREATE TABLE `codeworld_category_attribute`  (
  `t_category_attribute_id` bigint(20) NOT NULL COMMENT '分类属性主键id',
  `t_category_id` bigint(20) NULL DEFAULT NULL COMMENT '分类id',
  `t_attribute_id` bigint(20) NULL DEFAULT NULL COMMENT '属性id',
  `t_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_category_attribute_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_category_attribute
-- ----------------------------
INSERT INTO `codeworld_category_attribute` VALUES (128070, 500117, 709554, '2020-12-18 10:30:57', '2020-12-18 10:30:57');
INSERT INTO `codeworld_category_attribute` VALUES (232737, 500117, 513162, '2020-12-18 10:31:03', '2020-12-18 10:31:03');
INSERT INTO `codeworld_category_attribute` VALUES (368983, 500117, 225185, '2020-12-18 10:31:03', '2020-12-18 10:31:03');

-- ----------------------------
-- Table structure for codeworld_collection
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_collection`;
CREATE TABLE `codeworld_collection`  (
  `t_collection_id` bigint(20) NOT NULL COMMENT '收藏id主键',
  `t_product_id` bigint(20) NULL DEFAULT NULL COMMENT '商品Id',
  `t_product_sku_id` bigint(20) NULL DEFAULT NULL COMMENT '商品SkuId',
  `t_member_id` bigint(20) NULL DEFAULT NULL COMMENT '会员Id',
  `t_collection_time` datetime(0) NULL DEFAULT NULL COMMENT '收藏时间',
  `t_product_image` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `t_product_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品标题',
  `t_product_price` int(10) NULL DEFAULT NULL COMMENT '商品单价',
  PRIMARY KEY (`t_collection_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_collection
-- ----------------------------
INSERT INTO `codeworld_collection` VALUES (629630, 234364, NULL, 838395, '2021-03-09 14:16:17', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/06/77881612598154251.jpg', '小米MIX5 黑色 2000G', 11);

-- ----------------------------
-- Table structure for codeworld_dept
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_dept`;
CREATE TABLE `codeworld_dept`  (
  `t_dept_id` bigint(20) NOT NULL COMMENT '部门主键Id',
  `t_parent_id` bigint(20) NULL DEFAULT NULL COMMENT '部门上级Id',
  `t_dept_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `t_dept_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `t_dept_remarks` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '部门简介',
  `t_dept_sort_no` int(10) NULL DEFAULT NULL COMMENT '排序',
  `t_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_dept
-- ----------------------------
INSERT INTO `codeworld_dept` VALUES (1, 0, '系统部', 'menu', '系统部门', 1, '2020-10-13 14:34:00', '2020-11-06 11:47:44');
INSERT INTO `codeworld_dept` VALUES (2, 1, '人事部', 'button', '人事部门', 2, '2020-10-13 14:34:34', '2020-11-06 11:48:47');
INSERT INTO `codeworld_dept` VALUES (34763, 603358, 'Java开发部', NULL, 'Java开发', 1, '2020-11-06 11:49:24', '2020-11-06 11:49:24');
INSERT INTO `codeworld_dept` VALUES (295974, 2, '333', NULL, '333', 1, '2020-10-13 16:45:00', '2020-10-13 16:45:00');
INSERT INTO `codeworld_dept` VALUES (603358, 1, '开发部', NULL, '开发部门', 1, '2020-11-06 11:49:11', '2020-11-06 11:49:11');
INSERT INTO `codeworld_dept` VALUES (731841, 1, '222', NULL, '222', 2, '2020-10-13 16:44:29', '2020-10-13 16:44:29');
INSERT INTO `codeworld_dept` VALUES (999440, 1, '人员管理', NULL, '管理基本人员', 1, '2020-10-13 16:40:37', '2020-11-06 11:48:13');

-- ----------------------------
-- Table structure for codeworld_logistics
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_logistics`;
CREATE TABLE `codeworld_logistics`  (
  `t_logistics_id` bigint(20) NOT NULL COMMENT '物流主键Id',
  `t_logistics_delivery_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物流单号',
  `t_logistics_order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `t_logistics_arrive_time` datetime(0) NULL DEFAULT NULL COMMENT '物流到达时间',
  `t_logistics_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物流显示内容',
  `t_logistics_delivery_sn` int(11) NULL DEFAULT NULL COMMENT '物流编号',
  `t_logistics_operation_id` bigint(20) NULL DEFAULT NULL COMMENT '操作员Id',
  `t_logistics_operation_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作员姓名',
  PRIMARY KEY (`t_logistics_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_logistics
-- ----------------------------
INSERT INTO `codeworld_logistics` VALUES (343897, 'YD1614743001151', 21358680467441728, '2021-03-04 10:34:51', '已到达眉山', 3, 352024, NULL);
INSERT INTO `codeworld_logistics` VALUES (348852, 'YD1614743001151', 21358680467441728, '2021-03-04 10:18:16', '已到达眉山', 3, 352024, NULL);
INSERT INTO `codeworld_logistics` VALUES (472351, 'YD1614743001151', 21358680467441728, '2021-03-03 11:43:21', '订单开始处理', 3, NULL, NULL);
INSERT INTO `codeworld_logistics` VALUES (921557, 'YT1614742868425', 21358694282758208, '2021-03-03 11:41:09', '订单开始处理', 1, NULL, NULL);
INSERT INTO `codeworld_logistics` VALUES (933503, 'YD1614743001151', 21358680467441728, '2021-03-04 09:54:41', '已到达成都', 3, 352024, NULL);

-- ----------------------------
-- Table structure for codeworld_member
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_member`;
CREATE TABLE `codeworld_member`  (
  `t_member_id` bigint(20) NOT NULL COMMENT '会员主键Id',
  `t_member_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员名',
  `t_member_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员密码',
  `t_member_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员手机号码',
  `t_member_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_member_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_member_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_member
-- ----------------------------
INSERT INTO `codeworld_member` VALUES (491313, 'code', '123456', '15281223317', '2021-02-03 14:23:59', '2021-02-03 14:23:59');
INSERT INTO `codeworld_member` VALUES (838395, 'CodeWorld', '123456', '15281223316', '2020-12-22 14:33:06', '2020-12-22 14:33:06');

-- ----------------------------
-- Table structure for codeworld_member_detail
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_member_detail`;
CREATE TABLE `codeworld_member_detail`  (
  `t_member_id` bigint(20) NOT NULL COMMENT '会员id',
  `t_member_avatar` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员头像',
  `t_member_sex` int(1) NULL DEFAULT NULL COMMENT '会员性别 1--男 0--女',
  `t_member_create_time` datetime(0) NULL DEFAULT NULL,
  `t_member_update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`t_member_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_member_detail
-- ----------------------------
INSERT INTO `codeworld_member_detail` VALUES (491313, 'https://codewrold-community-1300450814.cos.ap-chengdu.myqcloud.com/2020/11/19/64741605768753169.jpg', 1, '2021-02-03 15:12:37', '2021-02-03 15:12:38');
INSERT INTO `codeworld_member_detail` VALUES (838395, 'https://codewrold-community-1300450814.cos.ap-chengdu.myqcloud.com/2020/11/19/64741605768753169.jpg', 1, '2020-12-25 14:51:08', '2020-12-25 14:51:11');

-- ----------------------------
-- Table structure for codeworld_member_receiver_address
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_member_receiver_address`;
CREATE TABLE `codeworld_member_receiver_address`  (
  `t_address_id` bigint(20) NOT NULL COMMENT '地址主键Id',
  `t_member_id` bigint(20) NULL DEFAULT NULL COMMENT '会员id',
  `t_receiver_name` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人名称',
  `t_receiver_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人名称',
  `t_address_area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人区域',
  `t_address_detailed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `t_receiver_house_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人门牌号',
  `t_address_status` int(1) NULL DEFAULT NULL COMMENT '收货地址状态 1--默认 0--其他',
  `t_address_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_address_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_address_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_member_receiver_address
-- ----------------------------
INSERT INTO `codeworld_member_receiver_address` VALUES (1000, 838395, '飞飞', '15281223316', '四川省-眉山市-仁寿县', '龙马镇', '五组', 1, '2020-12-23 17:59:20', '2020-12-28 17:37:39');
INSERT INTO `codeworld_member_receiver_address` VALUES (1002, 838395, '王若飞', '15281223316', '四川省-眉山市-仁寿县', '龙马镇', '五组', 0, '2020-12-24 10:10:13', '2020-12-25 11:30:13');
INSERT INTO `codeworld_member_receiver_address` VALUES (112113, 491313, '张三', '15281223317', '四川省-成都市-武侯区', '肖家河街道', '兴蓉东巷1号', 1, '2021-02-03 15:00:41', '2021-02-03 15:00:41');
INSERT INTO `codeworld_member_receiver_address` VALUES (146427, 838395, '王若飞', '15281223316', '四川省-眉山市-仁寿县', '龙马镇', '五组', 0, '2020-12-25 10:58:14', '2020-12-25 11:30:13');
INSERT INTO `codeworld_member_receiver_address` VALUES (566156, 838395, '王若飞', '15281223316', '四川省-眉山市-仁寿县', '龙马镇', '五组', 0, '2020-12-25 10:58:15', '2020-12-25 11:30:13');
INSERT INTO `codeworld_member_receiver_address` VALUES (996640, 838395, '王若飞', '15281223316', '四川省-眉山市-仁寿县', '龙马镇', '五组', 0, '2020-12-25 11:03:47', '2020-12-25 11:30:13');

-- ----------------------------
-- Table structure for codeworld_menu
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_menu`;
CREATE TABLE `codeworld_menu`  (
  `t_menu_id` bigint(20) NOT NULL COMMENT '菜单主键Id',
  `t_parent_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单上级Id',
  `t_menu_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单url',
  `t_menu_resources` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单编码',
  `t_menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `t_menu_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `t_menu_remarks` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '菜单简介',
  `t_menu_sort_no` int(10) NULL DEFAULT NULL COMMENT '排序',
  `t_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_menu
-- ----------------------------
INSERT INTO `codeworld_menu` VALUES (1000, 0, '/system-mamage', 'systemManage', '系统管理', 'menu', '系统管理', 1, '2020-09-18 17:05:59', '2020-09-18 17:06:01');
INSERT INTO `codeworld_menu` VALUES (1001, 1000, '/system-role', 'role', '角色管理', 'menu', '角色管理', 1, '2020-09-18 17:46:46', '2020-09-18 17:46:48');
INSERT INTO `codeworld_menu` VALUES (1002, 1000, '/system-menu', 'menu', '菜单管理', 'menu', '菜单管理', 1, '2020-09-18 17:48:41', '2020-09-18 17:48:43');
INSERT INTO `codeworld_menu` VALUES (1003, 1002, '/system-menu/add-menu', 'menu:add', '添加菜单', 'button', '添加菜单', 1, '2020-09-18 17:50:09', '2020-09-18 17:50:11');
INSERT INTO `codeworld_menu` VALUES (79472, 610542, '/codeworld-logistics/update-logistics', 'logistics:update', '物流更新', 'button', '物流更新接口', 1, '2021-03-04 09:50:08', '2021-03-04 09:50:08');
INSERT INTO `codeworld_menu` VALUES (85834, 431133, '/system-user/delete-user', 'user:delete', '删除用户', 'button', '删除一个用户', 5, '2020-09-20 10:33:56', '2020-09-20 10:33:56');
INSERT INTO `codeworld_menu` VALUES (113173, 0, '/codeworld-store', 'systemStore', '店铺管理', 'menu', '商户店铺管理', 1, '2021-03-02 09:21:00', '2021-03-02 09:21:00');
INSERT INTO `codeworld_menu` VALUES (125441, 906682, '/codeworld-mercahnt/examine-merchant', 'merchant:examine', '审核商户', 'button', '审核商户', 4, '2021-02-01 11:49:28', '2021-02-01 11:49:28');
INSERT INTO `codeworld_menu` VALUES (142731, 911538, '/codeworld-order/get-order-info-id', 'order:view', '查看订单', 'button', '查看订单', 2, '2021-01-08 17:05:08', '2021-01-08 17:05:08');
INSERT INTO `codeworld_menu` VALUES (183517, 934228, '/codeworld-marketing/get-page-index-carouse', 'index-carouse', '首页轮播图', 'menu', '首页轮播图', 1, '2021-01-13 14:25:45', '2021-01-13 15:43:12');
INSERT INTO `codeworld_menu` VALUES (192975, 0, '/system-goods', 'systemGoods', '商品管理', 'menu', '商品管理', 1, '2020-11-27 17:09:00', '2020-11-27 17:09:00');
INSERT INTO `codeworld_menu` VALUES (248235, 718023, '/codeworld-goods/category/update-category', 'category:update', '修改分类', 'button', '修改分类', 2, '2020-11-28 22:06:38', '2020-11-28 22:07:06');
INSERT INTO `codeworld_menu` VALUES (373292, 911538, '/codeworld-order/get-page-order', 'order:get', '订单列表', 'button', '订单列表', 1, '2021-01-08 16:01:42', '2021-01-08 16:01:42');
INSERT INTO `codeworld_menu` VALUES (399716, 431133, '/system-user/enable-user', 'user:enable', '启用用户', 'button', '启用用户', 2, '2020-09-19 14:39:10', '2020-09-19 14:39:10');
INSERT INTO `codeworld_menu` VALUES (414011, 1002, '/system-menu/delete-menu', 'menu:delete', '删除菜单', 'button', '删除菜单', 2, '2020-09-21 15:44:09', '2020-09-21 15:44:09');
INSERT INTO `codeworld_menu` VALUES (422057, 192975, '/codeworld-goods/product', 'product', '商品信息', 'menu', '商品信息', 1, '2020-11-28 22:14:12', '2020-11-28 22:14:12');
INSERT INTO `codeworld_menu` VALUES (426104, 183517, '/codeworld-marketing/carouse/review-carouse', 'review:carouse', '审核轮播图', 'button', '对轮播图进行审核，判断轮播图是否合法', 2, '2021-02-24 14:19:50', '2021-02-24 14:19:50');
INSERT INTO `codeworld_menu` VALUES (431133, 1000, '/system-user', 'user', '用户管理', 'menu', '用户管理', 1, '2020-09-19 14:36:18', '2020-09-19 14:36:18');
INSERT INTO `codeworld_menu` VALUES (436112, 906682, '/codeworld-merchant/merchant-settled', 'merchant:settled', '商户入驻', 'button', '商户入驻', 3, '2021-01-29 17:19:27', '2021-01-29 17:19:27');
INSERT INTO `codeworld_menu` VALUES (453077, 422057, '/codeworld-system/product/update-product-status', 'product:onSale', '上架商品', 'button', '上架商品信息', 1, '2021-01-06 09:28:22', '2021-01-06 09:28:22');
INSERT INTO `codeworld_menu` VALUES (482527, 422057, '/codeworld-goods/product/add-product', 'product:add', '添加商品', 'button', '添加商品', 1, '2020-11-28 22:15:20', '2020-11-28 22:15:20');
INSERT INTO `codeworld_menu` VALUES (483295, 103177, '/system-job/add-delete', 'job:delete', '添加任务', 'button', '添加任务', 1, '2020-09-22 17:07:14', '2020-09-22 17:07:14');
INSERT INTO `codeworld_menu` VALUES (506283, 1000, '/system-dept', 'dept', '部门管理', 'menu', '部门管理', 1, '2020-10-13 10:20:45', '2020-10-13 10:21:22');
INSERT INTO `codeworld_menu` VALUES (523925, 718023, '/codeworld-goods/category/add-category', 'category:add', '添加分类', 'button', '添加分类', 1, '2020-11-28 21:44:13', '2020-11-28 21:44:13');
INSERT INTO `codeworld_menu` VALUES (586170, 113173, '/codeworld-store/get-merchant-store-page', 'store', '店铺列表', 'button', '商户下的店铺列表', 1, '2021-03-02 09:21:55', '2021-03-02 09:21:55');
INSERT INTO `codeworld_menu` VALUES (609293, 183517, '/codeworld-marketing/carouse/delete-carouse', 'delete:carouse', '删除轮播图', 'button', '删除已过期的轮播图', 3, '2021-02-24 16:40:06', '2021-02-24 16:40:14');
INSERT INTO `codeworld_menu` VALUES (610542, 0, '/codeworld-logistics', 'logistics', '物流管理', 'menu', '物流管理模块', 1, '2021-03-04 09:49:18', '2021-03-04 09:49:18');
INSERT INTO `codeworld_menu` VALUES (639590, 1001, '/system-user/delete-user', 'role:delete', '删除角色', 'button', '删除角色', 3, '2020-09-19 15:21:10', '2020-09-19 15:21:10');
INSERT INTO `codeworld_menu` VALUES (652737, 192975, '/codeworld-goods/category-attribute', 'category-attribute', '分类属性', 'menu', '分类属性', 1, '2020-12-03 14:40:00', '2020-12-03 14:40:00');
INSERT INTO `codeworld_menu` VALUES (652906, 422057, '/codeworld-system/product/update-product-status ', 'product:offSale', '下架商品', 'button', '下架商品信息', 2, '2021-01-06 09:29:07', '2021-01-06 09:29:07');
INSERT INTO `codeworld_menu` VALUES (674600, 906682, '/codeworld-merchant/add-merchant', 'merchant:add', '添加商户', 'button', '添加商户，只能商户管理员来添加', 2, '2021-01-29 14:43:42', '2021-01-29 14:43:42');
INSERT INTO `codeworld_menu` VALUES (712174, 911538, '/codeworld-order/order-delivery', 'order:delivery', '订单发货', 'button', '订单发货', 4, '2021-01-10 12:31:52', '2021-01-10 12:31:52');
INSERT INTO `codeworld_menu` VALUES (718023, 192975, '/codeworld-goods/category', 'category', '分类管理', 'menu', '分类管理', 1, '2020-11-28 21:37:45', '2020-11-28 21:37:45');
INSERT INTO `codeworld_menu` VALUES (731821, 177739, '/system-login-log/delete-login-log', 'login-log:delete', '删除登录日志', 'button', '删除登录日志', 1, '2020-10-10 15:34:23', '2020-10-10 15:34:23');
INSERT INTO `codeworld_menu` VALUES (741955, 906682, '/codeworld-merchant/transfer-merchant', 'merchant:transfer', '商户转移', 'button', '将商户转移到别的商户管理员', 4, '2021-02-26 15:14:49', '2021-02-26 15:14:49');
INSERT INTO `codeworld_menu` VALUES (751273, 183517, '/codeworld-marketing/carouse/add-carouse', 'carouse:add', '添加轮播图', 'button', '添加轮播图', 1, '2021-01-13 15:41:25', '2021-01-13 15:41:25');
INSERT INTO `codeworld_menu` VALUES (759155, 1000, '/systemManage-chat', 'chat', '聊天室', 'menu', '聊天室', 1, '2020-09-25 11:04:05', '2020-09-25 11:04:05');
INSERT INTO `codeworld_menu` VALUES (767865, 1001, '/system-role/update-role', 'role:edit', '编辑角色', 'button', '编辑角色', 2, '2020-09-18 17:53:37', '2020-09-18 17:53:37');
INSERT INTO `codeworld_menu` VALUES (789006, 431133, '/system-user/update-user', 'user:edit', '编辑用户', 'button', '编辑用户', 4, '2020-09-19 22:22:35', '2020-09-19 22:22:35');
INSERT INTO `codeworld_menu` VALUES (806101, 911538, '/codeworld-order/delete-order', 'order:delete', '删除订单', 'button', '删除订单', 1, '2021-01-08 17:07:55', '2021-01-08 17:07:55');
INSERT INTO `codeworld_menu` VALUES (854257, 1001, '/system-role/add-role', 'role:add', '添加角色', 'button', '添加角色', 1, '2020-09-18 17:51:28', '2020-09-18 17:51:28');
INSERT INTO `codeworld_menu` VALUES (887057, 431133, '/system-user/add-user', 'user:add', '添加用户', 'button', '添加用户', 1, '2020-09-19 14:36:56', '2020-09-19 14:36:56');
INSERT INTO `codeworld_menu` VALUES (906682, 0, '/system-metchant', 'systemMerchant', '商户管理', 'menu', '商户管理', 1, '2021-01-04 15:37:34', '2021-01-04 15:37:34');
INSERT INTO `codeworld_menu` VALUES (911538, 0, '/codeworld-order', 'systemOrder', '订单管理', 'menu', '订单管理', 1, '2021-01-08 16:00:59', '2021-01-08 16:00:59');
INSERT INTO `codeworld_menu` VALUES (926053, 301087, '/system-monitor/offline-user-id', 'active:offline', '剔除用户', 'button', '将用户剔除下线', 1, '2020-10-20 11:38:20', '2020-10-20 11:38:20');
INSERT INTO `codeworld_menu` VALUES (934228, 0, '/codeworld-marketing', 'systemMarketing', '营销管理', 'menu', '营销管理', 1, '2021-01-13 14:22:48', '2021-01-13 14:27:28');
INSERT INTO `codeworld_menu` VALUES (940513, 906682, '/codeworld-merchant/get-page-merchant', 'merchant:view', '商户列表', 'button', '商户列表', 1, '2021-01-13 14:21:28', '2021-01-13 14:21:28');
INSERT INTO `codeworld_menu` VALUES (948807, 1002, '/system-menu/update-menu', 'menu:edit', '编辑菜单', 'button', '编辑菜单', 3, '2020-09-21 15:44:43', '2020-09-21 15:44:43');
INSERT INTO `codeworld_menu` VALUES (982791, 1001, '/system-role/set-role', 'roleSetting', '权限设置', 'button', '权限设置', 3, '2020-09-18 17:54:37', '2020-09-18 17:54:37');

-- ----------------------------
-- Table structure for codeworld_merchant
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_merchant`;
CREATE TABLE `codeworld_merchant`  (
  `t_merchant_id` bigint(20) NOT NULL COMMENT '商户id',
  `t_merchant_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户号',
  `t_merchant_nick_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户昵称',
  `t_merchant_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户手机',
  `t_merchant_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户登录密码',
  `t_merchant_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_merchant_follow_user` bigint(20) NULL DEFAULT NULL COMMENT '商户跟进人id',
  `t_merchant_avatar` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户头像',
  `t_merchant_password_salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户密码加盐salt',
  PRIMARY KEY (`t_merchant_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_merchant
-- ----------------------------
INSERT INTO `codeworld_merchant` VALUES (1608851327, '21181611095746339', 'codeworld', '15281223317', '987f1e5c65f634f21ba937f4e133e6be', '2021-01-07 17:04:35', 500649, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/08/46621612774814118.jpg', '7a0ab6a3797d4982b0a59c496d26450d');

-- ----------------------------
-- Table structure for codeworld_merchant_detail
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_merchant_detail`;
CREATE TABLE `codeworld_merchant_detail`  (
  `t_merchant_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商户号',
  `t_merchant_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家名称',
  `t_merchant_id_card_front` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证正面',
  `t_merchant_id_card_back` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证反面',
  `t_merchant_license` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '营业执照',
  `t_merchant_type` int(1) NULL DEFAULT NULL COMMENT '入驻类型 1--包月 2--包季 3--包年',
  `t_merchant_status` int(1) NULL DEFAULT NULL COMMENT '状态 1--已审核，且审核，2--未审核 0--审核失败 3--未入驻',
  `t_merchant_set_create_time` datetime(0) NULL DEFAULT NULL COMMENT '入驻时间',
  PRIMARY KEY (`t_merchant_number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_merchant_detail
-- ----------------------------
INSERT INTO `codeworld_merchant_detail` VALUES ('21181608848696318', '测试商户入驻', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/04/41881609743943658.jpg', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/04/41881609743943658.jpg', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/04/41881609743943658.jpg', 1, 1, '2021-01-05 16:58:15');
INSERT INTO `codeworld_merchant_detail` VALUES ('21181611095746339', '测试商户入驻2', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/04/41881609743943658.jpg', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/04/41881609743943658.jpg', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/04/41881609743943658.jpg', 1, 1, '2021-01-07 17:05:19');
INSERT INTO `codeworld_merchant_detail` VALUES ('21181612993494969', '测试商户入驻3', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/01/23011612150085833.jpg', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/01/89891612150146242.jpg', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/01/48871612150156143.jpg', 1, 0, '2021-02-01 11:30:29');

-- ----------------------------
-- Table structure for codeworld_order
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_order`;
CREATE TABLE `codeworld_order`  (
  `t_order_id` bigint(20) NOT NULL COMMENT '订单主键Id',
  `t_order_total_pay` bigint(20) NULL DEFAULT NULL COMMENT '订单总金额',
  `t_order_actual_pay` bigint(20) NULL DEFAULT NULL COMMENT '实付金额',
  `t_order_pay_type` int(1) NULL DEFAULT NULL COMMENT '支付类型 1--在线支付 2--货到付款',
  `t_order_post_fee` bigint(20) NULL DEFAULT NULL COMMENT '邮费',
  `t_order_member_id` bigint(20) NULL DEFAULT NULL COMMENT '会员id',
  `t_order_address_id` bigint(20) NULL DEFAULT NULL COMMENT '地址Id',
  `t_order_buyer_remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '买家备注信息',
  `t_order_buyer_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '买家会员名',
  `t_order_create_time` datetime(0) NULL DEFAULT NULL COMMENT '订单创建时间',
  `t_order_product_count` int(255) NULL DEFAULT NULL COMMENT '订单下总共的商品数量',
  PRIMARY KEY (`t_order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_order
-- ----------------------------
INSERT INTO `codeworld_order` VALUES (21206643257575488, 1, NULL, NULL, NULL, 838395, 1000, NULL, 'CodeWorld', '2021-02-04 15:11:11', NULL);
INSERT INTO `codeworld_order` VALUES (21206667199449152, 1, 1, NULL, NULL, 838395, 1000, NULL, 'CodeWorld', '2021-02-04 15:17:16', NULL);
INSERT INTO `codeworld_order` VALUES (21206749469870144, 1, 1, NULL, NULL, 838395, 1000, NULL, 'CodeWorld', '2021-02-04 15:38:12', NULL);
INSERT INTO `codeworld_order` VALUES (21207116026480704, 1, 1, NULL, NULL, 838395, 1000, NULL, 'CodeWorld', '2021-02-04 17:11:25', NULL);
INSERT INTO `codeworld_order` VALUES (21207142585010240, 1, 1, NULL, NULL, 838395, 1000, NULL, 'CodeWorld', '2021-02-04 17:18:10', NULL);
INSERT INTO `codeworld_order` VALUES (21207409546889280, 1, 1, NULL, NULL, 838395, 1000, NULL, 'CodeWorld', '2021-02-04 18:26:03', NULL);
INSERT INTO `codeworld_order` VALUES (21211111815317568, 1, NULL, NULL, NULL, 838395, 1000, NULL, 'CodeWorld', '2021-02-05 10:07:36', NULL);
INSERT INTO `codeworld_order` VALUES (21211115239376960, 2, NULL, NULL, NULL, 838395, 1000, NULL, 'CodeWorld', '2021-02-05 10:08:28', NULL);
INSERT INTO `codeworld_order` VALUES (21218107738228800, 1, 1, NULL, NULL, 838395, 1000, NULL, 'CodeWorld', '2021-02-06 15:46:45', NULL);
INSERT INTO `codeworld_order` VALUES (21218115306195008, 1, 1, NULL, NULL, 838395, 1000, NULL, 'CodeWorld', '2021-02-06 15:48:40', NULL);
INSERT INTO `codeworld_order` VALUES (21218120571488320, 9999, 9999, NULL, NULL, 838395, 1000, NULL, 'CodeWorld', '2021-02-06 15:50:01', NULL);
INSERT INTO `codeworld_order` VALUES (21218122410231872, 1, 1, NULL, NULL, 838395, 1000, NULL, 'CodeWorld', '2021-02-06 15:50:29', NULL);
INSERT INTO `codeworld_order` VALUES (21218124920719424, 1, 1, NULL, NULL, 838395, 1000, NULL, 'CodeWorld', '2021-02-06 15:51:07', NULL);
INSERT INTO `codeworld_order` VALUES (21218152741800000, 111, 111, NULL, NULL, 838395, 1000, NULL, 'CodeWorld', '2021-02-06 15:58:12', NULL);
INSERT INTO `codeworld_order` VALUES (21314810845399104, 11, 11, NULL, NULL, 838395, 1000, NULL, 'CodeWorld', '2021-02-23 17:39:37', NULL);
INSERT INTO `codeworld_order` VALUES (21318786400454720, 11, 11, NULL, NULL, 838395, 1000, NULL, 'CodeWorld', '2021-02-24 10:30:39', NULL);
INSERT INTO `codeworld_order` VALUES (21358680461871168, 11, 11, NULL, NULL, 838395, 1000, NULL, 'CodeWorld', '2021-03-03 11:36:14', NULL);
INSERT INTO `codeworld_order` VALUES (21358694282627136, 11, 11, NULL, NULL, 838395, 1000, NULL, 'CodeWorld', '2021-03-03 11:39:45', NULL);

-- ----------------------------
-- Table structure for codeworld_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_order_detail`;
CREATE TABLE `codeworld_order_detail`  (
  `t_order_detail_id` bigint(20) NOT NULL COMMENT '订单详情主键Id',
  `t_order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单id',
  `t_product_sku_id` bigint(20) NULL DEFAULT NULL COMMENT '商品Skuid',
  `t_product_count` int(10) NULL DEFAULT NULL COMMENT '商品购买数量',
  `t_product_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品标题',
  `t_product_sku_detail` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品Sku信息',
  `t_product_price` bigint(20) NULL DEFAULT NULL COMMENT '商品价格',
  `t_product_image` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `t_order_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_merchant_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户号',
  `t_order_delivery_company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单物流公司',
  `t_order_delivery_sn` int(10) NULL DEFAULT NULL COMMENT '物流编号',
  `t_order_delivery_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物流单号',
  PRIMARY KEY (`t_order_detail_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_order_detail
-- ----------------------------
INSERT INTO `codeworld_order_detail` VALUES (21206643258492992, 21206643257575488, 129735, 1, 'VivoX100 红色 1000G', '{\"id\":129735,\"price\":1,\"title\":\"红色 1000G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\"}', 1, NULL, '2021-02-04 15:11:11', '21181611095746339', '申通快递', 4, 'ST1612428967513');
INSERT INTO `codeworld_order_detail` VALUES (21206667199973440, 21206667199449152, 129735, 1, 'VivoX100 红色 1000G', '{\"id\":129735,\"price\":1,\"title\":\"红色 1000G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\"}', 1, NULL, '2021-02-04 15:17:16', '21181611095746339', '中通快递', 2, 'ZT1612427967712');
INSERT INTO `codeworld_order_detail` VALUES (21206749470394432, 21206749469870144, 129735, 1, 'VivoX100 红色 1000G', '{\"id\":129735,\"price\":1,\"title\":\"红色 1000G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\"}', 1, NULL, '2021-02-04 15:38:12', '21181611095746339', '圆通快递', 1, NULL);
INSERT INTO `codeworld_order_detail` VALUES (21207116027725888, 21207116026480704, 129735, 1, 'VivoX100 红色 1000G', '{\"id\":129735,\"price\":1,\"title\":\"红色 1000G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\"}', 1, NULL, '2021-02-04 17:11:25', '21181611095746339', NULL, NULL, NULL);
INSERT INTO `codeworld_order_detail` VALUES (21207142588745792, 21207142585010240, 86869, 1, NULL, '{\"id\":86869,\"price\":1,\"title\":\"Iphone20 红色 1000G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/96101609919575712.jpg\"}', 1, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/96101609919575712.jpg', '2021-02-04 17:18:10', '21181608848696318', NULL, NULL, NULL);
INSERT INTO `codeworld_order_detail` VALUES (21207409547348032, 21207409546889280, 129735, 1, NULL, '{\"id\":129735,\"price\":1,\"title\":\"VivoX100 红色 1000G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\"}', 1, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg', '2021-02-04 18:26:04', '21181611095746339', NULL, NULL, NULL);
INSERT INTO `codeworld_order_detail` VALUES (21211111819642944, 21211111815317568, 86869, 1, NULL, '{\"id\":86869,\"price\":1,\"title\":\"Iphone20 红色 1000G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/96101609919575712.jpg\"}', 1, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/96101609919575712.jpg', '2021-02-05 10:07:36', '21181608848696318', NULL, NULL, NULL);
INSERT INTO `codeworld_order_detail` VALUES (21211115239966784, 21211115239376960, 86869, 1, 'Iphone20 红色 1000G', '{\"id\":86869,\"price\":1,\"title\":\"红色 1000G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/96101609919575712.jpg\"}', 1, NULL, '2021-02-05 10:08:28', '21181608848696318', NULL, NULL, NULL);
INSERT INTO `codeworld_order_detail` VALUES (21211115240360000, 21211115239376960, 129735, 1, 'VivoX100 红色 1000G', '{\"id\":129735,\"price\":1,\"title\":\"红色 1000G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\"}', 1, NULL, '2021-02-05 10:08:28', '21181611095746339', NULL, NULL, NULL);
INSERT INTO `codeworld_order_detail` VALUES (21218107738622016, 21218107738228800, 129735, 1, NULL, '{\"id\":129735,\"price\":1,\"title\":\"VivoX100 红色 1000G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\"}', 1, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg', '2021-02-06 15:46:45', '21181611095746339', '韵达快递', 3, 'YD1612597688316');
INSERT INTO `codeworld_order_detail` VALUES (21218115307112512, 21218115306195008, 129735, 1, 'VivoX100 红色 1000G', '{\"id\":129735,\"price\":1,\"title\":\"红色 1000G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\"}', 1, NULL, '2021-02-06 15:48:40', '21181611095746339', NULL, NULL, NULL);
INSERT INTO `codeworld_order_detail` VALUES (21218120571684928, 21218120571488320, 189609, 1, NULL, '{\"id\":189609,\"price\":9999,\"title\":\"小米MIX2 绿色 20G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg\"}', 9999, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg', '2021-02-06 15:50:01', '21181608848696318', NULL, NULL, NULL);
INSERT INTO `codeworld_order_detail` VALUES (21218122411149376, 21218122410231872, 86869, 1, NULL, '{\"id\":86869,\"price\":1,\"title\":\"Iphone20 红色 1000G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/96101609919575712.jpg\"}', 1, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/96101609919575712.jpg', '2021-02-06 15:50:29', '21181608848696318', NULL, NULL, NULL);
INSERT INTO `codeworld_order_detail` VALUES (21218124920916032, 21218124920719424, 129735, 1, NULL, '{\"id\":129735,\"price\":1,\"title\":\"VivoX100 红色 1000G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\"}', 1, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg', '2021-02-06 15:51:07', '21181611095746339', NULL, NULL, NULL);
INSERT INTO `codeworld_order_detail` VALUES (21218152742062144, 21218152741800000, 751491, 1, NULL, '{\"id\":751491,\"price\":111,\"title\":\"小米MIX5 红色 1000G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/06/43181612598161912.jpg\"}', 111, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/06/77881612598154251.jpg', '2021-02-06 15:58:12', '21181611095746339', '申通快递', 4, 'ST1612598310157');
INSERT INTO `codeworld_order_detail` VALUES (21314810850445376, 21314810845399104, 31914, 1, NULL, '{\"id\":31914,\"price\":11,\"title\":\"小米MIX5 黑色 2000G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/06/77881612598154251.jpg\"}', 11, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/06/77881612598154251.jpg', '2021-02-23 17:39:37', '21181611095746339', NULL, NULL, NULL);
INSERT INTO `codeworld_order_detail` VALUES (21318786400913472, 21318786400454720, 31914, 1, '小米MIX5 黑色 2000G', '{\"id\":31914,\"price\":11,\"title\":\"黑色 2000G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/06/77881612598154251.jpg\"}', 11, NULL, '2021-02-24 10:30:39', '21181611095746339', NULL, NULL, NULL);
INSERT INTO `codeworld_order_detail` VALUES (21358680467441728, 21358680461871168, 31914, 1, NULL, '{\"id\":31914,\"price\":11,\"title\":\"小米MIX5 黑色 2000G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/06/77881612598154251.jpg\"}', 11, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/06/77881612598154251.jpg', '2021-03-03 11:36:15', '21181611095746339', '韵达快递', 3, 'YD1614743001151');
INSERT INTO `codeworld_order_detail` VALUES (21358694282758208, 21358694282627136, 31914, 1, NULL, '{\"id\":31914,\"price\":11,\"title\":\"小米MIX5 黑色 2000G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/06/77881612598154251.jpg\"}', 11, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/06/77881612598154251.jpg', '2021-03-03 11:39:45', '21181611095746339', '圆通快递', 1, 'YT1614742868425');

-- ----------------------------
-- Table structure for codeworld_order_evaluation
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_order_evaluation`;
CREATE TABLE `codeworld_order_evaluation`  (
  `t_order_detail_id` bigint(20) NOT NULL COMMENT '订单详情id',
  `t_order_evaluation_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '订单评价内容',
  `t_order_evaluation_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单评价图片',
  `t_order_evaluation_rate` int(1) NULL DEFAULT NULL COMMENT '订单商品评分',
  `t_order_evaluation_time` datetime(0) NULL DEFAULT NULL COMMENT '评价时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_order_evaluation
-- ----------------------------
INSERT INTO `codeworld_order_evaluation` VALUES (21218152741800000, '12345', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/22/85261613988411776.jpg', 4, '2021-02-22 18:06:56');
INSERT INTO `codeworld_order_evaluation` VALUES (21218152741800000, '123445', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/22/3911613988842691.jpg', 3, '2021-02-22 18:14:12');
INSERT INTO `codeworld_order_evaluation` VALUES (21218152742062144, '12345', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/22/23951613989008314.jpg', 3, '2021-02-22 18:16:54');
INSERT INTO `codeworld_order_evaluation` VALUES (21218107738622016, '好', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/22/58531613989067952.jpg', 3, '2021-02-22 18:17:53');
INSERT INTO `codeworld_order_evaluation` VALUES (21206749470394432, '好的', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/23/41771614042990886.jpg', 3, '2021-02-23 09:16:37');
INSERT INTO `codeworld_order_evaluation` VALUES (21206667199973440, 'ViVo不好', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/23/39791614044997514.jpg', 2, '2021-02-23 09:50:02');
INSERT INTO `codeworld_order_evaluation` VALUES (21206643258492992, '好', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/23/51931614061762074.jpg', 3, '2021-02-23 14:29:27');

-- ----------------------------
-- Table structure for codeworld_order_return
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_order_return`;
CREATE TABLE `codeworld_order_return`  (
  `t_return_order_id` bigint(20) NOT NULL COMMENT '退货订单主键id',
  `t_order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单id 对饮订单明细中的t_order_detail_id',
  `t_return_order_status` int(1) NULL DEFAULT NULL COMMENT '订单退货 退款状态 0--待处理 1--退款中 2--退款成功 3--退货中 4--退货成功 5--拒绝退款 6---拒绝退货',
  `t_return_handle_time` datetime(0) NULL DEFAULT NULL COMMENT '处理时间',
  `t_return_order_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退货原因',
  `t_return_order_apply_time` datetime(0) NULL DEFAULT NULL COMMENT '订单退款退货申请时间',
  `t_return_order_type` int(1) NULL DEFAULT NULL COMMENT '订单服务类型 1--退款 3---退货',
  `t_return_order_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`t_return_order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_order_return
-- ----------------------------
INSERT INTO `codeworld_order_return` VALUES (21207199559059520, 21207142588745792, 1, '2021-02-04 18:08:46', NULL, '2021-02-04 17:32:39', 1, NULL);
INSERT INTO `codeworld_order_return` VALUES (21210887542540352, 21207409547348032, 5, '2021-02-05 09:16:09', NULL, '2021-02-05 09:10:33', 1, NULL);
INSERT INTO `codeworld_order_return` VALUES (21210912175818816, 21207116027725888, 1, '2021-02-05 09:17:12', NULL, '2021-02-05 09:16:49', 1, NULL);
INSERT INTO `codeworld_order_return` VALUES (21218115885336640, 21218115307112512, 1, '2021-02-06 15:49:30', NULL, '2021-02-06 15:48:49', 1, NULL);
INSERT INTO `codeworld_order_return` VALUES (21218120806893632, 21218120571684928, 0, NULL, NULL, '2021-02-06 15:50:04', 1, NULL);
INSERT INTO `codeworld_order_return` VALUES (21218122626238528, 21218122411149376, 0, NULL, NULL, '2021-02-06 15:50:32', 1, NULL);
INSERT INTO `codeworld_order_return` VALUES (21218125598033984, 21218124920916032, 5, '2021-02-06 15:51:32', NULL, '2021-02-06 15:51:17', 1, NULL);
INSERT INTO `codeworld_order_return` VALUES (21318468496263232, 21218152742062144, 5, '2021-02-24 09:56:56', '尺寸不合适', '2021-02-24 09:09:49', 3, NULL);
INSERT INTO `codeworld_order_return` VALUES (21318557106440256, 21314810850445376, 1, '2021-02-24 09:56:25', NULL, '2021-02-24 09:32:21', 1, NULL);
INSERT INTO `codeworld_order_return` VALUES (21318787627092032, 21318786400913472, 1, '2021-02-24 10:31:35', NULL, '2021-02-24 10:30:58', 1, '已经发货了');

-- ----------------------------
-- Table structure for codeworld_order_status
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_order_status`;
CREATE TABLE `codeworld_order_status`  (
  `t_order_id` bigint(20) NOT NULL COMMENT '订单id 对饮订单明细中的t_order_detail_id',
  `t_order_status` int(1) NULL DEFAULT NULL COMMENT '订单状态 1、未付款 2、已付款,未发货 3、已发货,未确认 4、交易成功 5、交易关闭 6、已评价 7、失效订单\r\n8、售后服务 9、未评价',
  `t_order_create_time` datetime(0) NULL DEFAULT NULL COMMENT '订单创建时间',
  `t_order_pay_time` datetime(0) NULL DEFAULT NULL COMMENT '订单付款时间',
  `t_order_consign_time` datetime(0) NULL DEFAULT NULL COMMENT '订单发货时间',
  `t_order_end_time` datetime(0) NULL DEFAULT NULL COMMENT '订单结束时间',
  `t_order_close_time` datetime(0) NULL DEFAULT NULL COMMENT '订单关闭时间',
  PRIMARY KEY (`t_order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_order_status
-- ----------------------------
INSERT INTO `codeworld_order_status` VALUES (21206643258492992, 4, '2021-02-04 15:11:11', '2021-02-04 15:39:24', '2021-02-04 16:56:08', NULL, '2021-02-23 09:55:44');
INSERT INTO `codeworld_order_status` VALUES (21206667199973440, 4, '2021-02-04 15:17:16', '2021-02-04 15:39:26', '2021-02-04 16:39:28', NULL, '2021-02-23 09:25:17');
INSERT INTO `codeworld_order_status` VALUES (21206749470394432, 4, '2021-02-04 15:38:12', '2021-02-04 15:38:19', '2021-02-04 16:37:15', NULL, '2021-02-23 09:15:16');
INSERT INTO `codeworld_order_status` VALUES (21207116027725888, 8, '2021-02-04 17:11:25', '2021-02-05 09:16:45', NULL, NULL, '2021-02-05 09:16:49');
INSERT INTO `codeworld_order_status` VALUES (21207142588745792, 8, '2021-02-04 17:18:10', '2021-02-04 17:18:18', NULL, NULL, '2021-02-04 17:32:39');
INSERT INTO `codeworld_order_status` VALUES (21207409547348032, 8, '2021-02-04 18:26:04', '2021-02-05 09:09:57', NULL, NULL, '2021-02-05 09:10:33');
INSERT INTO `codeworld_order_status` VALUES (21211111819642944, 5, '2021-02-05 10:07:36', NULL, NULL, NULL, '2021-02-05 10:07:45');
INSERT INTO `codeworld_order_status` VALUES (21211115239966784, 5, '2021-02-05 10:08:28', NULL, NULL, NULL, '2021-02-05 10:14:50');
INSERT INTO `codeworld_order_status` VALUES (21211115240360000, 5, '2021-02-05 10:08:28', NULL, NULL, NULL, '2021-02-05 10:14:50');
INSERT INTO `codeworld_order_status` VALUES (21218107738622016, 4, '2021-02-06 15:46:45', '2021-02-06 15:47:11', '2021-02-06 15:48:08', NULL, '2021-02-20 17:14:55');
INSERT INTO `codeworld_order_status` VALUES (21218115307112512, 8, '2021-02-06 15:48:40', '2021-02-06 15:48:42', NULL, NULL, '2021-02-06 15:48:49');
INSERT INTO `codeworld_order_status` VALUES (21218120571684928, 8, '2021-02-06 15:50:01', '2021-02-06 15:50:02', NULL, NULL, '2021-02-06 15:50:04');
INSERT INTO `codeworld_order_status` VALUES (21218122411149376, 8, '2021-02-06 15:50:29', '2021-02-06 15:50:30', NULL, NULL, '2021-02-06 15:50:32');
INSERT INTO `codeworld_order_status` VALUES (21218124920916032, 8, '2021-02-06 15:51:07', '2021-02-06 15:51:08', NULL, NULL, '2021-02-06 15:51:17');
INSERT INTO `codeworld_order_status` VALUES (21218152742062144, 8, '2021-02-06 15:58:12', '2021-02-06 15:58:12', '2021-02-06 15:58:30', NULL, '2021-02-20 17:13:43');
INSERT INTO `codeworld_order_status` VALUES (21314810850445376, 8, '2021-02-23 17:39:37', '2021-02-23 17:39:41', NULL, NULL, '2021-02-24 09:32:21');
INSERT INTO `codeworld_order_status` VALUES (21318786400913472, 8, '2021-02-24 10:30:39', '2021-02-24 10:30:40', NULL, NULL, '2021-02-24 10:30:58');
INSERT INTO `codeworld_order_status` VALUES (21358680467441728, 3, '2021-03-03 11:36:15', '2021-03-03 11:36:40', '2021-03-03 11:43:21', NULL, NULL);
INSERT INTO `codeworld_order_status` VALUES (21358694282758208, 3, '2021-03-03 11:39:45', '2021-03-03 11:39:52', '2021-03-03 11:41:08', NULL, NULL);

-- ----------------------------
-- Table structure for codeworld_param
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_param`;
CREATE TABLE `codeworld_param`  (
  `t_param_id` bigint(20) NOT NULL COMMENT '参数主键Id',
  `t_param_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数名称',
  `t_special_param` int(1) NULL DEFAULT NULL COMMENT '是否是特殊属性 1--是，0--不是',
  `t_attribute_id` bigint(20) NULL DEFAULT NULL COMMENT '属性Id',
  `t_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_param_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_param
-- ----------------------------
INSERT INTO `codeworld_param` VALUES (671913, 'CPU型号', 0, 513162, '2020-12-18 10:32:01', '2020-12-18 10:32:01');
INSERT INTO `codeworld_param` VALUES (833900, '操作系统', 0, 513162, '2020-12-18 10:32:08', '2020-12-18 10:32:08');
INSERT INTO `codeworld_param` VALUES (878010, '颜色', 1, 513162, '2020-12-18 10:31:43', '2020-12-18 10:31:43');
INSERT INTO `codeworld_param` VALUES (879798, '内存', 1, 513162, '2020-12-18 10:31:54', '2020-12-18 10:31:54');

-- ----------------------------
-- Table structure for codeworld_product
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_product`;
CREATE TABLE `codeworld_product`  (
  `t_product_id` bigint(20) NOT NULL COMMENT '商品主键Id',
  `t_product_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品标题',
  `t_product_sub_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品二级标题',
  `t_product_category_id` bigint(20) NULL DEFAULT NULL COMMENT '商品分类id',
  `t_product_brand_id` bigint(20) NULL DEFAULT NULL COMMENT '商品品牌id',
  `t_product_saleable` int(1) NULL DEFAULT NULL COMMENT '商品状态 1-上架 0-下架',
  `t_product_merchant_id` bigint(20) NULL DEFAULT NULL COMMENT '商户Id',
  `t_product_create_time` datetime(0) NULL DEFAULT NULL COMMENT '添加时间',
  `t_product_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_product
-- ----------------------------
INSERT INTO `codeworld_product` VALUES (234364, '小米MIX5', NULL, 500117, NULL, 1, 1608851327, '2021-02-06 15:56:22', '2021-02-06 15:56:29');
INSERT INTO `codeworld_product` VALUES (668339, 'Iphone20', NULL, 500117, NULL, 1, 1609046703, '2021-01-06 15:53:36', '2021-01-06 15:53:41');
INSERT INTO `codeworld_product` VALUES (711211, 'VivoX100', NULL, 500117, NULL, 1, 1608851327, '2021-01-07 17:10:59', '2021-01-08 16:59:27');
INSERT INTO `codeworld_product` VALUES (897175, '小米MIX2', NULL, 500117, NULL, 1, 1609046703, '2020-12-18 10:33:54', '2020-12-18 10:33:56');

-- ----------------------------
-- Table structure for codeworld_product_detail
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_product_detail`;
CREATE TABLE `codeworld_product_detail`  (
  `t_product_id` bigint(20) UNSIGNED ZEROFILL NOT NULL COMMENT '商品id',
  `t_product_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品描述信息',
  `t_product_generic_param` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品通用参数',
  `t_product_special_param` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品特殊参数',
  `t_product_packing_list` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品包装信息',
  `t_product_after_service` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品售后服务',
  `t_product_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_product_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_product_detail
-- ----------------------------
INSERT INTO `codeworld_product_detail` VALUES (00000000000000234364, '终身包换', '{\"671913\":\"\",\"833900\":\"\",\"878010\":\"\",\"879798\":\"\"}', '{\"878010\":[\"黑色\",\"红色\"],\"879798\":[\"1000G\",\"2000G\"]}', '一个小米MIX5', '终生包换', '2021-02-06 15:56:22', '2021-02-06 15:56:22');
INSERT INTO `codeworld_product_detail` VALUES (00000000000000668339, 'iPhone20又大又好看，还终身包换', '{\"671913\":\"A20\",\"833900\":\"iPhone\"}', '{\"878010\":[\"红色\",\"绿色\"],\"879798\":[\"1000G\",\"2000G\"]}', '1个IPhone20手机', '终生包换', '2021-01-06 15:53:36', '2021-01-06 15:53:36');
INSERT INTO `codeworld_product_detail` VALUES (00000000000000711211, 'Vivo手机终生包换', '{\"671913\":\"骁龙1000\",\"833900\":\"Android\"}', '{\"878010\":[\"红色\"],\"879798\":[\"1000G\"]}', '一个手机', '终生包换', '2021-01-07 17:10:59', '2021-01-07 17:10:59');
INSERT INTO `codeworld_product_detail` VALUES (00000000000000897175, '小米值得信赖', '{\"671913\":\"骁龙10000\",\"833900\":\"Android\"}', '{\"878010\":[\"红色\",\"绿色\"],\"879798\":[\"10G\",\"20G\"]}', '一个手机', '终身包换', '2020-12-18 10:33:54', '2020-12-18 10:33:54');

-- ----------------------------
-- Table structure for codeworld_product_sku
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_product_sku`;
CREATE TABLE `codeworld_product_sku`  (
  `t_product_sku_id` bigint(20) NOT NULL COMMENT '商品Sku主键Id',
  `t_product_id` bigint(20) NULL DEFAULT NULL COMMENT '商品Id',
  `t_product_sku_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品标题',
  `t_product_sku_price` int(10) NULL DEFAULT NULL COMMENT '商品价格',
  `t_product_sku_own_spec` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品规格参数',
  `t_product_sku_images` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品图片',
  `t_product_sku_create_time` datetime(0) NULL DEFAULT NULL COMMENT '商品创建时间',
  `t_product_sku_update_time` datetime(0) NULL DEFAULT NULL COMMENT '商品更新时间',
  PRIMARY KEY (`t_product_sku_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_product_sku
-- ----------------------------
INSERT INTO `codeworld_product_sku` VALUES (31914, 234364, '小米MIX5 黑色 2000G', 11, '{\"878010\":\"黑色\",\"879798\":\"2000G\"}', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/06/77881612598154251.jpg', '2021-02-06 15:56:22', '2021-02-06 15:56:22');
INSERT INTO `codeworld_product_sku` VALUES (86869, 668339, 'Iphone20 红色 1000G', 1, '{\"878010\":\"红色\",\"879798\":\"1000G\"}', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/96101609919575712.jpg', '2021-01-06 15:53:36', '2021-01-06 15:53:36');
INSERT INTO `codeworld_product_sku` VALUES (129735, 711211, 'VivoX100 红色 1000G', 1, '{\"878010\":\"红色\",\"879798\":\"1000G\"}', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg', '2021-01-07 17:10:59', '2021-01-07 17:10:59');
INSERT INTO `codeworld_product_sku` VALUES (177905, 668339, 'Iphone20 绿色 2000G', 4, '{\"878010\":\"绿色\",\"879798\":\"2000G\"}', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/76471609919611150.jpg', '2021-01-06 15:53:36', '2021-01-06 15:53:36');
INSERT INTO `codeworld_product_sku` VALUES (185457, 668339, 'Iphone20 绿色 1000G', 3, '{\"878010\":\"绿色\",\"879798\":\"1000G\"}', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/58571609919598472.jpg', '2021-01-06 15:53:36', '2021-01-06 15:53:36');
INSERT INTO `codeworld_product_sku` VALUES (189609, 897175, '小米MIX2 绿色 20G', 9999, '{\"878010\":\"绿色\",\"879798\":\"20G\"}', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg', '2020-12-18 10:33:54', '2020-12-18 10:33:54');
INSERT INTO `codeworld_product_sku` VALUES (430732, 897175, '小米MIX2 绿色 10G', 999, '{\"878010\":\"绿色\",\"879798\":\"10G\"}', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/95801608258823988.jpg', '2020-12-18 10:33:54', '2020-12-18 10:33:54');
INSERT INTO `codeworld_product_sku` VALUES (451278, 897175, '小米MIX2 红色 10G', 9, '{\"878010\":\"红色\",\"879798\":\"10G\"}', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/39141608258804944.jpg', '2020-12-18 10:33:54', '2020-12-18 10:33:54');
INSERT INTO `codeworld_product_sku` VALUES (465882, 668339, 'Iphone20 红色 2000G', 2, '{\"878010\":\"红色\",\"879798\":\"2000G\"}', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/87311609919589441.jpg', '2021-01-06 15:53:36', '2021-01-06 15:53:36');
INSERT INTO `codeworld_product_sku` VALUES (652896, 234364, '小米MIX5 黑色 1000G', 1, '{\"878010\":\"黑色\",\"879798\":\"1000G\"}', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/06/80291612598147777.jpg', '2021-02-06 15:56:22', '2021-02-06 15:56:22');
INSERT INTO `codeworld_product_sku` VALUES (743942, 234364, '小米MIX5 红色 2000G', 1111, '{\"878010\":\"红色\",\"879798\":\"2000G\"}', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/06/94471612598179777.jpg', '2021-02-06 15:56:22', '2021-02-06 15:56:22');
INSERT INTO `codeworld_product_sku` VALUES (751491, 234364, '小米MIX5 红色 1000G', 111, '{\"878010\":\"红色\",\"879798\":\"1000G\"}', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/02/06/43181612598161912.jpg', '2021-02-06 15:56:22', '2021-02-06 15:56:22');
INSERT INTO `codeworld_product_sku` VALUES (756668, 897175, '小米MIX2 红色 20G', 99, '{\"878010\":\"红色\",\"879798\":\"20G\"}', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/39601608258814803.jpg', '2020-12-18 10:33:54', '2020-12-18 10:33:54');

-- ----------------------------
-- Table structure for codeworld_role
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_role`;
CREATE TABLE `codeworld_role`  (
  `t_role_id` bigint(20) NOT NULL COMMENT '角色主键Id',
  `t_role_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色编码',
  `t_role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `t_role_remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `t_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_role
-- ----------------------------
INSERT INTO `codeworld_role` VALUES (1, 'admin', '系统管理员', '拥有最高权限', '2020-09-16 20:10:33', '2020-10-20 09:36:20');
INSERT INTO `codeworld_role` VALUES (31845, 'merchant-system', '商户管理员', '对商户进行管理', '2021-01-28 17:09:39', '2021-01-28 17:09:39');
INSERT INTO `codeworld_role` VALUES (127341, 'default', '默认用户', '只有查看权限', '2020-11-06 09:26:01', '2020-11-06 09:43:06');
INSERT INTO `codeworld_role` VALUES (422935, 'marketing-system', '营销管理员', '营销管理员主要管理营销模块', '2021-02-24 14:16:36', '2021-02-24 14:16:36');
INSERT INTO `codeworld_role` VALUES (574669, 'logistics', '物流人员', '物流人员主要是对订单发货后的，物流更新操作', '2021-03-04 09:52:04', '2021-03-04 09:52:04');
INSERT INTO `codeworld_role` VALUES (853858, 'merchant', '商户', '商户用户', '2021-01-04 15:39:53', '2021-01-04 15:39:53');
INSERT INTO `codeworld_role` VALUES (982301, 'register', '注册用户', '只有一般的查看权限', '2020-09-21 16:06:21', '2020-11-06 09:13:43');

-- ----------------------------
-- Table structure for codeworld_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_role_menu`;
CREATE TABLE `codeworld_role_menu`  (
  `t_role_menu_id` bigint(20) NOT NULL COMMENT '角色菜单主键Id',
  `t_role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色Id',
  `t_menu_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单Id',
  `t_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_role_menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_role_menu
-- ----------------------------
INSERT INTO `codeworld_role_menu` VALUES (25900, 853858, 712174, '2021-03-02 09:23:46', '2021-03-02 09:23:46');
INSERT INTO `codeworld_role_menu` VALUES (61297, 127341, 1002, '2020-11-06 09:26:38', '2020-11-06 09:26:38');
INSERT INTO `codeworld_role_menu` VALUES (74871, 1, 506283, '2021-02-24 14:21:14', '2021-02-24 14:21:14');
INSERT INTO `codeworld_role_menu` VALUES (75708, 853858, 1003, '2021-03-02 09:23:46', '2021-03-02 09:23:46');
INSERT INTO `codeworld_role_menu` VALUES (104192, 127341, 1001, '2020-11-06 09:26:38', '2020-11-06 09:26:38');
INSERT INTO `codeworld_role_menu` VALUES (105330, 422935, 426104, '2021-02-24 16:40:39', '2021-02-24 16:40:39');
INSERT INTO `codeworld_role_menu` VALUES (147864, 853858, 523925, '2021-03-02 09:23:46', '2021-03-02 09:23:46');
INSERT INTO `codeworld_role_menu` VALUES (172130, 31845, 906682, '2021-02-26 15:15:01', '2021-02-26 15:15:01');
INSERT INTO `codeworld_role_menu` VALUES (176437, 853858, 422057, '2021-03-02 09:23:46', '2021-03-02 09:23:46');
INSERT INTO `codeworld_role_menu` VALUES (179762, 1, 789006, '2021-02-24 14:21:14', '2021-02-24 14:21:14');
INSERT INTO `codeworld_role_menu` VALUES (208103, 853858, 911538, '2021-03-02 09:23:46', '2021-03-02 09:23:46');
INSERT INTO `codeworld_role_menu` VALUES (228644, 1, 1003, '2021-02-24 14:21:14', '2021-02-24 14:21:14');
INSERT INTO `codeworld_role_menu` VALUES (263160, 31845, 125441, '2021-02-26 15:15:01', '2021-02-26 15:15:01');
INSERT INTO `codeworld_role_menu` VALUES (270713, 31845, 674600, '2021-02-26 15:15:01', '2021-02-26 15:15:01');
INSERT INTO `codeworld_role_menu` VALUES (270723, 1, 1002, '2021-02-24 14:21:14', '2021-02-24 14:21:14');
INSERT INTO `codeworld_role_menu` VALUES (288399, 853858, 482527, '2021-03-02 09:23:46', '2021-03-02 09:23:46');
INSERT INTO `codeworld_role_menu` VALUES (317529, 853858, 373292, '2021-03-02 09:23:46', '2021-03-02 09:23:46');
INSERT INTO `codeworld_role_menu` VALUES (331294, 853858, 453077, '2021-03-02 09:23:46', '2021-03-02 09:23:46');
INSERT INTO `codeworld_role_menu` VALUES (342954, 982301, 1003, '2021-02-01 09:28:04', '2021-02-01 09:28:04');
INSERT INTO `codeworld_role_menu` VALUES (343752, 1, 414011, '2021-02-24 14:21:14', '2021-02-24 14:21:14');
INSERT INTO `codeworld_role_menu` VALUES (353700, 127341, 759155, '2020-11-06 09:26:38', '2020-11-06 09:26:38');
INSERT INTO `codeworld_role_menu` VALUES (366230, 982301, 436112, '2021-02-01 09:28:04', '2021-02-01 09:28:04');
INSERT INTO `codeworld_role_menu` VALUES (384495, 1, 399716, '2021-02-24 14:21:14', '2021-02-24 14:21:14');
INSERT INTO `codeworld_role_menu` VALUES (391763, 853858, 192975, '2021-03-02 09:23:46', '2021-03-02 09:23:46');
INSERT INTO `codeworld_role_menu` VALUES (400758, 853858, 586170, '2021-03-02 09:23:46', '2021-03-02 09:23:46');
INSERT INTO `codeworld_role_menu` VALUES (406957, 31845, 741955, '2021-02-26 15:15:01', '2021-02-26 15:15:01');
INSERT INTO `codeworld_role_menu` VALUES (423147, 1, 759155, '2021-02-24 14:21:14', '2021-02-24 14:21:14');
INSERT INTO `codeworld_role_menu` VALUES (431674, 422935, 934228, '2021-02-24 16:40:39', '2021-02-24 16:40:39');
INSERT INTO `codeworld_role_menu` VALUES (487448, 1, 639590, '2021-02-24 14:21:14', '2021-02-24 14:21:14');
INSERT INTO `codeworld_role_menu` VALUES (501202, 1, 767865, '2021-02-24 14:21:14', '2021-02-24 14:21:14');
INSERT INTO `codeworld_role_menu` VALUES (551139, 31845, 940513, '2021-02-26 15:15:01', '2021-02-26 15:15:01');
INSERT INTO `codeworld_role_menu` VALUES (568690, 853858, 934228, '2021-03-02 09:23:46', '2021-03-02 09:23:46');
INSERT INTO `codeworld_role_menu` VALUES (580802, 853858, 436112, '2021-03-02 09:23:46', '2021-03-02 09:23:46');
INSERT INTO `codeworld_role_menu` VALUES (594825, 127341, 506283, '2020-11-06 09:26:38', '2020-11-06 09:26:38');
INSERT INTO `codeworld_role_menu` VALUES (624546, 422935, 183517, '2021-02-24 16:40:39', '2021-02-24 16:40:39');
INSERT INTO `codeworld_role_menu` VALUES (626120, 853858, 751273, '2021-03-02 09:23:46', '2021-03-02 09:23:46');
INSERT INTO `codeworld_role_menu` VALUES (632621, 1, 982791, '2021-02-24 14:21:14', '2021-02-24 14:21:14');
INSERT INTO `codeworld_role_menu` VALUES (642704, 1, 431133, '2021-02-24 14:21:14', '2021-02-24 14:21:14');
INSERT INTO `codeworld_role_menu` VALUES (714013, 1, 1000, '2021-02-24 14:21:14', '2021-02-24 14:21:14');
INSERT INTO `codeworld_role_menu` VALUES (776476, 1, 887057, '2021-02-24 14:21:14', '2021-02-24 14:21:14');
INSERT INTO `codeworld_role_menu` VALUES (787729, 853858, 948807, '2021-03-02 09:23:46', '2021-03-02 09:23:46');
INSERT INTO `codeworld_role_menu` VALUES (795282, 853858, 414011, '2021-03-02 09:23:46', '2021-03-02 09:23:46');
INSERT INTO `codeworld_role_menu` VALUES (808083, 1, 854257, '2021-02-24 14:21:14', '2021-02-24 14:21:14');
INSERT INTO `codeworld_role_menu` VALUES (816422, 1, 1001, '2021-02-24 14:21:14', '2021-02-24 14:21:14');
INSERT INTO `codeworld_role_menu` VALUES (817089, 853858, 142731, '2021-03-02 09:23:46', '2021-03-02 09:23:46');
INSERT INTO `codeworld_role_menu` VALUES (821927, 853858, 248235, '2021-03-02 09:23:46', '2021-03-02 09:23:46');
INSERT INTO `codeworld_role_menu` VALUES (842479, 853858, 652906, '2021-03-02 09:23:46', '2021-03-02 09:23:46');
INSERT INTO `codeworld_role_menu` VALUES (880650, 1, 948807, '2021-02-24 14:21:14', '2021-02-24 14:21:14');
INSERT INTO `codeworld_role_menu` VALUES (887038, 422935, 609293, '2021-02-24 16:40:39', '2021-02-24 16:40:39');
INSERT INTO `codeworld_role_menu` VALUES (920762, 127341, 431133, '2020-11-06 09:26:38', '2020-11-06 09:26:38');
INSERT INTO `codeworld_role_menu` VALUES (921461, 1, 85834, '2021-02-24 14:21:14', '2021-02-24 14:21:14');
INSERT INTO `codeworld_role_menu` VALUES (923843, 853858, 806101, '2021-03-02 09:23:46', '2021-03-02 09:23:46');
INSERT INTO `codeworld_role_menu` VALUES (931526, 853858, 113173, '2021-03-02 09:23:46', '2021-03-02 09:23:46');
INSERT INTO `codeworld_role_menu` VALUES (949335, 127341, 1000, '2020-11-06 09:26:38', '2020-11-06 09:26:38');
INSERT INTO `codeworld_role_menu` VALUES (950904, 982301, 854257, '2021-02-01 09:28:04', '2021-02-01 09:28:04');
INSERT INTO `codeworld_role_menu` VALUES (989503, 853858, 183517, '2021-03-02 09:23:46', '2021-03-02 09:23:46');

-- ----------------------------
-- Table structure for codeworld_stock
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_stock`;
CREATE TABLE `codeworld_stock`  (
  `t_product_sku_id` bigint(20) NOT NULL COMMENT '商品skuId',
  `t_product_stock` int(10) NULL DEFAULT NULL COMMENT '商品库存',
  PRIMARY KEY (`t_product_sku_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_stock
-- ----------------------------
INSERT INTO `codeworld_stock` VALUES (31914, 1);
INSERT INTO `codeworld_stock` VALUES (652896, 1);
INSERT INTO `codeworld_stock` VALUES (743942, 4);
INSERT INTO `codeworld_stock` VALUES (751491, 3);

-- ----------------------------
-- Table structure for codeworld_store
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_store`;
CREATE TABLE `codeworld_store`  (
  `t_store_id` bigint(20) NOT NULL COMMENT '店铺id',
  `t_store_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '店铺名称',
  `t_store_status` int(1) NULL DEFAULT NULL COMMENT '店铺状态 1--启用中 2--未启用',
  `t_store_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_store_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `t_merchant_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户号',
  PRIMARY KEY (`t_store_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_store
-- ----------------------------
INSERT INTO `codeworld_store` VALUES (859010, '测试店铺', 2, '2021-03-08 16:40:06', '2021-03-08 16:40:06', '21181611095746339');

-- ----------------------------
-- Table structure for codeworld_user
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_user`;
CREATE TABLE `codeworld_user`  (
  `t_user_id` bigint(20) NOT NULL COMMENT '用户主键Id',
  `t_user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `t_nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `t_user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `t_user_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `t_user_status` int(1) NULL DEFAULT NULL COMMENT '用户状态 1--启用 0--禁用',
  `t_area_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户所属区域\r\n',
  `t_create_time` datetime(0) NULL DEFAULT NULL COMMENT '加入时间',
  `t_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `t_area_id` bigint(20) NULL DEFAULT NULL COMMENT '区域Id',
  `t_user_avatar` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `t_user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `t_user_password_salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码加盐加密',
  `t_user_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户备注',
  PRIMARY KEY (`t_user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_user
-- ----------------------------
INSERT INTO `codeworld_user` VALUES (352024, 'WL000000', NULL, '1692454247@qq.com', '15281223316', 1, '四川省,成都市,市辖区,武侯区', '2021-03-04 09:53:02', '2021-03-04 09:53:02', 510107, NULL, '6e3c7d2322ead93a98d7e739662710cf', 'c554c9b126cf4259b397c007e5b65e43', '物流人员');
INSERT INTO `codeworld_user` VALUES (434870, 'codeworld', NULL, '1692454247@qq.com', '15281223316', 1, '四川省,眉山市,仁寿县', '2020-11-05 10:13:02', '2021-01-29 11:49:20', 511421, NULL, '0e1960a2122a65c0a6d0e8f514277270', '25ce089f73f24b39a0f6ae7224e38ae9', NULL);
INSERT INTO `codeworld_user` VALUES (500649, 'FC000000', NULL, '1692454247@qq.com', '15281223316', 1, '辽宁省,大连市,市辖区,中山区', '2021-01-28 17:10:29', '2021-01-29 11:47:56', 210202, NULL, '136ce5e62a0fd8fdf8125c5927bed8f4', '5ee35b6e2e62456881447ee1f4c2df34', NULL);
INSERT INTO `codeworld_user` VALUES (502000, 'FC000003', NULL, '1692454247@qq.com', '15281223316', 1, '辽宁省,大连市,市辖区,中山区', '2021-02-26 15:58:47', '2021-02-26 15:58:47', 210202, NULL, 'c1c5ec9c406350aaaa2a16e1daf44d84', '4c92b3f5f67a482da25f0aaafee44073', NULL);
INSERT INTO `codeworld_user` VALUES (594594, 'FC000001', NULL, '1692454247@qq.com', '15281223316', 1, '河北省,唐山市,滦县', '2021-01-29 10:32:22', '2021-01-29 11:44:45', 130223, NULL, '335efc5154964c598c4eece29f38d693', '8f0936a2b86f4c81b09476a0e3bf9cc5', NULL);
INSERT INTO `codeworld_user` VALUES (658105, 'M00001', NULL, '1692454247@qq.com', '15281223316', 1, '四川省,成都市,市辖区,武侯区', '2021-02-24 14:17:17', '2021-02-24 14:17:17', 510107, NULL, '7738d83e1df8fc3a08acf7a899e8384a', '8f5dd8351f194bfe8dc9aa17891b46e4', NULL);
INSERT INTO `codeworld_user` VALUES (714564, 'FC', NULL, '1692454247@qq.com', '15281223316', 1, '辽宁省,大连市,市辖区,西岗区', '2020-11-06 09:21:02', '2021-01-29 11:48:12', 210203, NULL, 'c127df20d617286601c23a1302548eba', '118527413b09442685e1014e2eae49e4', NULL);
INSERT INTO `codeworld_user` VALUES (722708, 'code', NULL, '1692454247@qq.com', '15281223316', 1, '四川省,成都市,市辖区,武侯区', '2020-11-05 17:01:13', '2021-01-29 11:48:57', 510107, NULL, 'c1cbead5b92e5528bc2a0ae156861975', '6bef544843934092bc6596d816a8f302', NULL);

-- ----------------------------
-- Table structure for codeworld_user_dept
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_user_dept`;
CREATE TABLE `codeworld_user_dept`  (
  `t_user_dept_id` bigint(20) NOT NULL COMMENT '用户部门主键Id',
  `t_user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户Id',
  `t_dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门id',
  `t_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_user_dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_user_dept
-- ----------------------------
INSERT INTO `codeworld_user_dept` VALUES (265345, 434870, 603358, '2021-01-29 11:49:20', '2021-01-29 11:49:20');
INSERT INTO `codeworld_user_dept` VALUES (277684, 502000, 999440, '2021-02-26 15:58:47', '2021-02-26 15:58:47');
INSERT INTO `codeworld_user_dept` VALUES (302843, 722708, 1, '2021-01-29 11:48:57', '2021-01-29 11:48:57');
INSERT INTO `codeworld_user_dept` VALUES (356666, 594594, 999440, '2021-01-29 11:44:45', '2021-01-29 11:44:45');
INSERT INTO `codeworld_user_dept` VALUES (488279, 352024, 999440, '2021-03-04 09:53:02', '2021-03-04 09:53:02');
INSERT INTO `codeworld_user_dept` VALUES (645997, 500649, 999440, '2021-01-29 11:47:56', '2021-01-29 11:47:56');
INSERT INTO `codeworld_user_dept` VALUES (797844, 714564, 731841, '2021-01-29 11:48:12', '2021-01-29 11:48:12');
INSERT INTO `codeworld_user_dept` VALUES (951390, 658105, 999440, '2021-02-24 14:17:17', '2021-02-24 14:17:17');

-- ----------------------------
-- Table structure for codeworld_user_role
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_user_role`;
CREATE TABLE `codeworld_user_role`  (
  `t_user_role_id` bigint(20) NOT NULL COMMENT '用户角色表主键Id',
  `t_role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色Id',
  `t_user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户Id',
  `t_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_user_role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_user_role
-- ----------------------------
INSERT INTO `codeworld_user_role` VALUES (110485, 1, 434870, '2021-01-29 11:49:20', '2021-01-29 11:49:20');
INSERT INTO `codeworld_user_role` VALUES (125360, 853858, 1608851327, '2021-01-07 17:04:35', '2021-01-07 17:04:35');
INSERT INTO `codeworld_user_role` VALUES (142107, 982301, 1610747344, '2021-01-29 15:44:51', '2021-01-29 15:44:51');
INSERT INTO `codeworld_user_role` VALUES (263636, 422935, 658105, '2021-02-24 14:17:17', '2021-02-24 14:17:17');
INSERT INTO `codeworld_user_role` VALUES (311835, 982301, 722708, '2021-01-29 11:48:57', '2021-01-29 11:48:57');
INSERT INTO `codeworld_user_role` VALUES (344480, 574669, 352024, '2021-03-04 09:53:02', '2021-03-04 09:53:02');
INSERT INTO `codeworld_user_role` VALUES (493008, 31845, 502000, '2021-02-26 15:58:47', '2021-02-26 15:58:47');
INSERT INTO `codeworld_user_role` VALUES (654044, 853858, 714564, '2021-01-29 11:48:12', '2021-01-29 11:48:12');
INSERT INTO `codeworld_user_role` VALUES (840122, 853858, 1609046703, '2021-01-05 16:42:14', '2021-01-05 16:42:14');
INSERT INTO `codeworld_user_role` VALUES (873996, 853858, 1610749076, '2021-01-29 16:13:43', '2021-01-29 16:13:43');
INSERT INTO `codeworld_user_role` VALUES (926419, 31845, 500649, '2021-01-29 11:47:56', '2021-01-29 11:47:56');
INSERT INTO `codeworld_user_role` VALUES (938153, 31845, 594594, '2021-01-29 11:44:45', '2021-01-29 11:44:45');

SET FOREIGN_KEY_CHECKS = 1;
