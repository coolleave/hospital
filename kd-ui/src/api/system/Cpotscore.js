import request from '@/utils/request'

// 查询重症护理疼痛观察列表
export function listCpotscore(query) {
  return request({
    url: '/system/Cpotscore/list',
    method: 'get',
    params: query
  })
}

// 查询重症护理疼痛观察详细
export function getCpotscore(Id) {
  return request({
    url: '/system/Cpotscore/' + Id,
    method: 'get'
  })
}

// 新增重症护理疼痛观察
export function addCpotscore(data) {
  return request({
    url: '/system/Cpotscore',
    method: 'post',
    data: data
  })
}

// 修改重症护理疼痛观察
export function updateCpotscore(data) {
  return request({
    url: '/system/Cpotscore',
    method: 'put',
    data: data
  })
}

// 删除重症护理疼痛观察
export function delCpotscore(Id) {
  return request({
    url: '/system/Cpotscore/' + Id,
    method: 'delete'
  })
}
export function listCpotByEncounterId(encounterId) {
  return request({
    url: '/system/Cpotscore/list2',
    method: 'get',
    params: { encounterId }
  })
}